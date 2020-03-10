package top.wycfight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: wycfight@163.com
 * @description:
 * @create: 2020-02-26 18:00
 * @modify By:
 **/
@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan(basePackages = "top.wycfight.mapper")
@ComponentScan(basePackages = {"top.wycfight","top.n3r.idworker"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
