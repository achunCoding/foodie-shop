package top.wycfight.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.enums.YesOrNo;
import top.wycfight.pojo.Carousel;
import top.wycfight.pojo.Category;
import top.wycfight.pojo.vo.CategoryVO;
import top.wycfight.pojo.vo.NewItemsVo;
import top.wycfight.service.CarouselService;
import top.wycfight.service.CategoryService;
import top.wycfight.utils.JSONResult;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description: Hello Demo
 * @create: 2020-02-26 18:19
 * @modify By:
 **/
@RestController
@Api(tags = "用于首页相关接口", value = "首页")
@RequestMapping("index")
public class IndexController {


    @Autowired
    private CarouselService carouselService;

    @Autowired
    private CategoryService categoryService;


    /**
     * 查询展示的轮播图
     *
     * @return
     */
    @GetMapping("carousel")
    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    public JSONResult carousel() {
        List<Carousel> carousels = carouselService.queryAll(YesOrNo.yes.type);
        return JSONResult.ok(carousels);
    }


    /**
     * 获取商品分类
     *
     * @return
     */
    @GetMapping("cats")
    @ApiOperation(value = "获取商品一级分类", notes = "获取商品一级分类", httpMethod = "GET")
    public JSONResult cats() {
        List<Category> carousels = categoryService.queryAllRootLevelCat();
        return JSONResult.ok(carousels);
    }

    /**
     * 获取商品分类
     *
     * @return
     */
    @GetMapping("/subCat/{rootCatId}")
    @ApiOperation(value = "获取商品子分类", notes = "获取商品一级分类", httpMethod = "GET")
    public JSONResult subCat(
            @ApiParam(name = "rootCatId", value = "一级分类id")
            @PathVariable(value = "rootCatId") Integer rootCatId) {
        if (rootCatId == null) {
            return JSONResult.errorMsg("分类ID为空");
        }
        List<CategoryVO> categoryVOList = categoryService.getSubCatList(rootCatId);
        return JSONResult.ok(categoryVOList);
    }

    /**
     * 查询每一个分类下最新六件商品
     *
     * @return
     */
    @GetMapping("/sixNewItems/{rootCatId}")
    @ApiOperation(value = "查询每一个分类下最新六件商品", notes = "查询每一个分类下最新六件商品", httpMethod = "GET")
    public JSONResult sixNewItems(
            @ApiParam(name = "rootCatId", value = "一级分类id")
            @PathVariable(value = "rootCatId") Integer rootCatId) {
        if (rootCatId == null) {
            return JSONResult.errorMsg("分类ID为空");
        }
        List<NewItemsVo> newItemsVo = categoryService.getSixNewItemsLazy(rootCatId);
        return JSONResult.ok(newItemsVo);
    }
}
