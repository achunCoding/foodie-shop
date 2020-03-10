package top.wycfight.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 分类下最新商品VO
 * @create: 2020-03-08 09:13
 * @modify By:
 **/
@Data
public class NewItemsVo {
    private Integer rootCatId;

    private String rootCatName;

    private String slogan;

    private String catImage;

    private String bgColor;

    private List<SimpleItemVo> simpleItemList;



}
