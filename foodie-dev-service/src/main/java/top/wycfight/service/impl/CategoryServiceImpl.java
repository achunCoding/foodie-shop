package top.wycfight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import top.wycfight.mapper.CategoryDao;
import top.wycfight.mapper.CategoryMapper;
import top.wycfight.pojo.Carousel;
import top.wycfight.pojo.Category;
import top.wycfight.pojo.vo.CategoryVO;
import top.wycfight.pojo.vo.NewItemsVo;
import top.wycfight.service.CategoryService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 分类Service实现类
 * @create: 2020-03-07 12:25
 * @modify By:
 **/
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private CategoryDao categoryDao;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Category> queryAllRootLevelCat() {
        Example example = new Example(Category.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type", 1);
        return categoryMapper.selectByExample(example);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        return categoryDao.getSubList(rootCatId);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<NewItemsVo> getSixNewItemsLazy(Integer rootCatId) {
        Map<String, Object> params = new HashMap<>();
        params.put("rootCatId", rootCatId);
        return categoryDao.getSixNewItemsLazy(params);
    }
}
