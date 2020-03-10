package top.wycfight.pojo.vo;

import lombok.Data;

/**
 * @author: wycfight@163.com
 * @description: 评价
 * @create: 2020-03-10 20:24
 * @modify By:
 **/
@Data
public class CommentLevelCountsVO {

    private Integer totalCounts;

    private Integer goodCounts;
    private Integer normalCounts;
    private Integer badCounts;
}
