package top.wycfight.mapper;


import org.apache.ibatis.annotations.Param;
import top.wycfight.pojo.vo.ItemsCommentVO;
import top.wycfight.pojo.vo.SearchItemsVO;

import java.util.List;
import java.util.Map;

public interface ItemsDao  {
    /**
     * 查询商品评价
     * @param params 请求参数
     * @return
     */
    List<ItemsCommentVO> queryItemComments(@Param("params") Map<String, Object> params);

    /**
     * 查询所有搜索商品
     * @return
     */
    List<SearchItemsVO> searchItems(@Param("params") Map<String, Object> params);

    /**
     * 通过三级分类ID查询商品信息
     * @param map
     * @return
     */
    List<ItemsCommentVO> searchItemsByCatId(@Param("params") Map<String,Object> map);
}