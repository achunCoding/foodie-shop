package top.wycfight.service;

import top.wycfight.pojo.Carousel;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2020-03-07 10:43
 * @modify By:
 **/
public interface CarouselService {
    /**
     * 查询所有显示的轮播图
     * @param isShow
     * @return
     */
    List<Carousel> queryAll(Integer isShow);
}
