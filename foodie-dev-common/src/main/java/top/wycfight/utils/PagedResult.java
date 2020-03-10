package top.wycfight.utils;

import lombok.Data;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: 用来返回分页数据 （封装）
 * @create: 2020-03-10 21:26
 * @modify By:
 **/
@Data
public class PagedResult {
    /**
     * 当前页
     */
    private int page;
    /**
     * 总页数
     */
    private int total;
    /**
     * 总记录数
     */
    private long records;
    /**
     * 显示内容
     */
    private List<?> rows;


}
