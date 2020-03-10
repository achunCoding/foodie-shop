package top.wycfight.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @author: wycfight@163.com
 * @description 跨域配置
 * @create: 2020-03-05 09:05
 * @modify By:
 **/
@Configuration
public class CorsConfig {
    public CorsConfig() {

    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://47.103.9.247:8080");
        // 设置是否发送cookie信息
        corsConfiguration.setAllowCredentials(true);
        // 设置允许请求的方式
        corsConfiguration.addAllowedMethod("*");
        // 设置允许的Header
        corsConfiguration.addAllowedHeader("*");

        // 为url添加映射路径
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        // 返回定义新的配置
        return new CorsFilter(source);
    }
}
