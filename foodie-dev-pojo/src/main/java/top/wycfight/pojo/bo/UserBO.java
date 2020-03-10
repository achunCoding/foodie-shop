package top.wycfight.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2020-02-29 12:32
 * @modify By:
 **/
@Data
@ApiModel(value = "用户对象BO", description = "从客户端，由用户传入的数据封装在此entity中")
public class UserBO {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", name = "username", example = "achun", required = true)
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", name = "password", example = "123456", required = true)
    private String password;
    /**
     * 确认密码
     */
    @ApiModelProperty(value = "确认密码", name = "confirmPassword", example = "123456", required = true)
    private String confirmPassword;
}
