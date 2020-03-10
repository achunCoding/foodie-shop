package top.wycfight.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wycfight.pojo.Stu;
import top.wycfight.service.StuService;

/**
 * @author: wycfight@163.com
 * @description: Hello Demo
 * @create: 2020-02-26 18:19
 * @modify By:
 **/
@RestController
public class HelloController {


    @Autowired
    private StuService stuService;


    @GetMapping("/getStu")
    public Object getStu(int id) {
        return stuService.getStuInfo(id);
    }

    @GetMapping("/saveStu")
    public Object saveStu(Stu stu) {
        stuService.saveStu(stu);
        return "OK";
    }

    @GetMapping("/updateStu")
    public Object updateStu(Stu stu) {
        stuService.updateStu(stu);
        return "OK";
    }

    @GetMapping("/deleteStu")
    public Object deleteStu(int id) {
        stuService.deleteStu(id);
        return "OK";
    }
}
