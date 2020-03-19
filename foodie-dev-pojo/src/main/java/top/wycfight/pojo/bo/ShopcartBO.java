package top.wycfight.pojo.bo;

import lombok.Data;

/**
 * @author: wycfight@163.com
 * @description: 购物车对象
 * @create: 2020-03-15 15:05
 * @modify By:
 **/
@Data
public class ShopcartBO {
    /**
     * 商品ID
     */
    private String itemId;

    /**
     * 商品主图
     */
    private String itemImgUrl;
    /**
     * 商品名称
     */
    private String itemName;
    /**
     * 规格ID
     */
    private String specId;
    /**
     * 规格名称
     */
    private String specName;
    /**
     * 购买数量
     */
    private Integer buyCounts;
    /**
     * 打折价
     */
    private Integer priceDiscount;
    /**
     * 正常价
     */
    private Integer priceNormal;
}
