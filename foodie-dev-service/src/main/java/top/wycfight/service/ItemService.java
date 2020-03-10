package top.wycfight.service;

import top.wycfight.pojo.Items;
import top.wycfight.pojo.ItemsImg;
import top.wycfight.pojo.ItemsParam;
import top.wycfight.pojo.ItemsSpec;
import top.wycfight.pojo.vo.CommentLevelCountsVO;
import top.wycfight.utils.PagedResult;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 商品Service
 * @create: 2020-03-08 15:17
 * @modify By:
 **/
public interface ItemService {

    /**
     * 通过Id查询商品信息
     *
     * @param itemId 商品ID
     * @return
     */
    Items queryItemById(String itemId);

    /**
     * 通过商品ID查询商品图片列表
     *
     * @param itemId
     * @return
     */
    List<ItemsImg> queryItemImgList(String itemId);


    /**
     * 通过商品ID查询商品规格
     *
     * @param itemId
     * @return
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 通过商品ID查询商品信息
     *
     * @param itemId
     * @return
     */
    ItemsParam queryItemParam(String itemId);

    /**
     * 获取评价(好评 中评 差评)
     *
     * @param itemId
     */
    CommentLevelCountsVO queryCommnetCounts(String itemId);

    /**
     * 获取评价内容
     * @param itemId 商品ID
     * @param level 评价等级
     * @return
     */
    PagedResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);

}
