package top.wycfight.enums;

/**
 * @author: wycfight@163.com
 * @description: 性别枚举
 * @create: 2020-02-29 12:29
 * @modify By:
 **/
public enum Sex {


    woman(0,"女"),
    man(1,"男"),
    secret(2,"保密");

    public final Integer type;
    public final String value;

    Sex(Integer type, String value) {
        this.type = type;
        this.value = value;
    }
}
