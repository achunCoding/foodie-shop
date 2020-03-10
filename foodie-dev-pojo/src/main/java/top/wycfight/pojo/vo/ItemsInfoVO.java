package top.wycfight.pojo.vo;

import lombok.Data;
import top.wycfight.pojo.Items;
import top.wycfight.pojo.ItemsImg;
import top.wycfight.pojo.ItemsParam;
import top.wycfight.pojo.ItemsSpec;

import java.util.List;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2020-03-08 16:22
 * @modify By:
 **/
@Data
public class ItemsInfoVO {

    private Items item;

    private List<ItemsImg> itemImgList;

    private List<ItemsSpec> itemSpecList;

    private ItemsParam itemParams;
}
