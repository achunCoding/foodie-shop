package top.wycfight.enums;

/**
 * @author: wycfight@163.com
 * @description: 评价枚举
 * @create: 2020-02-29 12:29
 * @modify By:
 **/
public enum CommentLevel {


    GOOD(1,"好评"),
    NORMAL(2,"中评"),
    BAD(3,"差评");

    public final Integer type;
    public final String value;

    CommentLevel(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
