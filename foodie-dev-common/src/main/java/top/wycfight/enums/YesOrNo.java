package top.wycfight.enums;

/**
 * @author: wycfight@163.com
 * @description: 性别枚举
 * @create: 2020-02-29 12:29
 * @modify By:
 **/
public enum YesOrNo {


    no(0,"否"),
    yes(1,"是");

    public final Integer type;
    public final String value;

    YesOrNo(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
