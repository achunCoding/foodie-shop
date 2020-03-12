package top.wycfight.pojo.vo;

import lombok.Data;

/**
 * @author: wycfight@163.com
 * @description: 商品搜索商品VO
 * @create: 2020-03-11 21:23
 * @modify By:
 **/
@Data
public class SearchItemsVO {

    private String itemId;
    private String itemName;
    private Integer sellCounts;
    private String imgUrl;
    private Integer price;
}
