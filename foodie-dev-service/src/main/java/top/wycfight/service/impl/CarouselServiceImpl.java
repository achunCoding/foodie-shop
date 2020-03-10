package top.wycfight.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;
import top.wycfight.mapper.CarouselMapper;
import top.wycfight.pojo.Carousel;
import top.wycfight.service.CarouselService;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2020-03-07 10:43
 * @modify By:
 **/
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;


    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example example = new Example(Carousel.class);
        example.orderBy("sort").desc();
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("isShow", isShow);
        return carouselMapper.selectByExample(example);
    }
}
