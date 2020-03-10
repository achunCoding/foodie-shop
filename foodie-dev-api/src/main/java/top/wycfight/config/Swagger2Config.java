package top.wycfight.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author: wycfight@163.com
 * @description: Swagger2配置
 * @create: 2020-03-04 10:19
 * @modify By:
 **/
@Configuration
@EnableSwagger2
public class Swagger2Config {
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2) // 指定api类型为swagger2
                .apiInfo(apiInfo()) //用于Api文档汇总
                .select().apis(RequestHandlerSelectors.basePackage("top.wycfight.controller")) // 扫描指定Controller包
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("阿春 电商平台接口api")
                .contact(new Contact("achun","http://wycfight.top","wycfight@163.com"))
                .description("专为阿春平台提供的api文档")
                .version("0.0.1")
                .termsOfServiceUrl("http://wycfight.top").build();
    }
}
