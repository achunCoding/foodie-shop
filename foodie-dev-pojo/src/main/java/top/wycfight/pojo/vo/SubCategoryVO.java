package top.wycfight.pojo.vo;

import lombok.Data;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2020-03-07 14:43
 * @modify By:
 **/
@Data
public class SubCategoryVO {

    private Integer subId;

    private String subName;

    private Integer subType;

    private Integer subFatherId;
}
