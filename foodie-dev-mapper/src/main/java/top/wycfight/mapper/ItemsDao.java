package top.wycfight.mapper;


import org.apache.ibatis.annotations.Param;
import top.wycfight.pojo.vo.ItemsCommentVO;

import java.util.List;
import java.util.Map;

public interface ItemsDao  {

    List<ItemsCommentVO> queryItemComments(@Param("params") Map<String, Object> params);
}