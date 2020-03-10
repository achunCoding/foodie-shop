package top.wycfight.pojo.vo;

import lombok.Data;

import java.util.Date;

/**
 * @author: wycfight@163.com
 * @description: 商品评价内容展示VO
 * @create: 2020-03-08 16:22
 * @modify By:
 **/
@Data
public class ItemsCommentVO {

    private Integer commentLevel;
    private String  content;
    private Date createdTime;
    private String sepcName;
    private String userFace;
    private String nickName;


}
