package top.wycfight.pojo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2020-03-07 14:39
 * @modify By:
 **/
@Data
public class CategoryVO {

    private Integer id;

    private String name;

    private Integer type;

    private Integer fatherId;

    private List<SubCategoryVO> subCatList;
}
