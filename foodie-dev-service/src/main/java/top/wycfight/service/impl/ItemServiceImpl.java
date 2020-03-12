package top.wycfight.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import top.wycfight.enums.CommentLevel;
import top.wycfight.mapper.*;
import top.wycfight.pojo.*;
import top.wycfight.pojo.vo.CommentLevelCountsVO;
import top.wycfight.pojo.vo.ItemsCommentVO;
import top.wycfight.pojo.vo.ItemsInfoVO;
import top.wycfight.pojo.vo.SearchItemsVO;
import top.wycfight.service.ItemService;
import top.wycfight.utils.DesensitizationUtil;
import top.wycfight.utils.PagedResult;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 商品Service实现类
 * @create: 2020-03-08 15:20
 * @modify By:
 **/
@Service
public class ItemServiceImpl implements ItemService {


    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private ItemsImgMapper itemsImgMapper;

    @Autowired
    private ItemsSpecMapper itemsSpecMapper;

    @Autowired
    private ItemsParamMapper itemsParamMapper;

    @Autowired
    private ItemsCommentsMapper itemsCommentsMapper;

    @Autowired
    private ItemsDao itemsDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Items queryItemById(String itemId) {
        return itemsMapper.selectByPrimaryKey(itemId);
    }



    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ItemsImg> queryItemImgList(String itemId) {
        Example example = new Example(ItemsImg.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId", itemId);
        return itemsImgMapper.selectByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ItemsSpec> queryItemSpecList(String itemId) {
        Example example = new Example(ItemsSpec.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId", itemId);
        return itemsSpecMapper.selectByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public ItemsParam queryItemParam(String itemId) {
        Example example = new Example(ItemsParam.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("itemId", itemId);
        return itemsParamMapper.selectOneByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public CommentLevelCountsVO queryCommnetCounts(String itemId) {
        // 获取好评中评 差评
        CommentLevelCountsVO result = new CommentLevelCountsVO();
        Integer goodCounts = getCommentCounts(itemId, CommentLevel.GOOD.type);
        Integer normalCounts = getCommentCounts(itemId, CommentLevel.NORMAL.type);
        Integer badCounts = getCommentCounts(itemId, CommentLevel.BAD.type);
        Integer totalCounts = goodCounts + normalCounts + badCounts;
        result.setBadCounts(badCounts);
        result.setGoodCounts(goodCounts);
        result.setNormalCounts(normalCounts);
        result.setTotalCounts(totalCounts);
        return result;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    Integer getCommentCounts(String itemId, Integer level) {
        ItemsComments itemsComments = new ItemsComments();
        itemsComments.setItemId(itemId);
        if (level != null) {
            itemsComments.setCommentLevel(level);
        }
        return itemsCommentsMapper.selectCount(itemsComments);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PagedResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("itemId", itemId);
        map.put("commentLevel", level);

        PageHelper.startPage(page, pageSize);
        List<ItemsCommentVO> list = itemsDao.queryItemComments(map);
        for (ItemsCommentVO itemsCommentVO : list) {
            itemsCommentVO.setNickName(DesensitizationUtil.getStarString(itemsCommentVO.getNickName(),2,8));
        }
        return setterPaged(list,page);

    }

    /**
     * 封装分页返回参数
     * @return
     */
    private PagedResult setterPaged(List<?> list, Integer page) {
        PageInfo pageInfo = new PageInfo(list);
        PagedResult pagedResult = new PagedResult();
        pagedResult.setPage(page);
        pagedResult.setRows(list);
        pagedResult.setRecords(pageInfo.getTotal());
        pagedResult.setTotal(pageInfo.getPages());
        return pagedResult;
    }

    @Override
    public PagedResult searchItemsByCatId(Integer catId, String sort, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("catId", catId);
        map.put("sort", sort);

        PageHelper.startPage(page, pageSize);
        List<SearchItemsVO> list = itemsDao.searchItemsByCatId(map);
        return setterPaged(list,page);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public PagedResult searchItems(String keywords, String sort, Integer page, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("keywords", keywords);
        map.put("sort", sort);

        PageHelper.startPage(page, pageSize);
        List<SearchItemsVO> list = itemsDao.searchItems(map);
        return setterPaged(list,page);
    }
}
