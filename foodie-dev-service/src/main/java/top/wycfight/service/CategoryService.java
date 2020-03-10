package top.wycfight.service;

import top.wycfight.pojo.Category;
import top.wycfight.pojo.vo.CategoryVO;
import top.wycfight.pojo.vo.NewItemsVo;

import java.util.List;
import java.util.Map;

/**
 * @author: wycfight@163.com
 * @description: 分类Service
 * @create: 2020-03-07 12:24
 * @modify By:
 **/
public interface CategoryService {


    /**
     * 查询所有一级分类
     * @return
     */
    List<Category> queryAllRootLevelCat();

    /**
     * 自关联查询子分类
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * 获取分类六件商品
     * @param params
     * @return
     */
    List<NewItemsVo> getSixNewItemsLazy(Integer rootCatId);
}
