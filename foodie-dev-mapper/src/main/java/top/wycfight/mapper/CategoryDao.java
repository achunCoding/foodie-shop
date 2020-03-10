package top.wycfight.mapper;


import org.apache.ibatis.annotations.Param;
import top.wycfight.pojo.vo.CategoryVO;
import top.wycfight.pojo.vo.NewItemsVo;

import java.util.List;
import java.util.Map;

public interface CategoryDao {

    /**
     * 获取子分类
     * @param fatherId
     * @return
     */
    List<CategoryVO> getSubList(@Param("fatherId") Integer fatherId);

    /**
     * 获取分类下的六件最新商品
     * @param params
     * @return
     */
    List<NewItemsVo> getSixNewItemsLazy(@Param("params") Map<String, Object> params);


}