package top.wycfight.service;

import top.wycfight.pojo.Stu;

/**
 * @author: wycfight@163.com
 * @description: 学生Servcie接口
 * @create: 2020-02-27 19:49
 * @modify By:
 **/
public interface StuService {
    /**
     * 获取学生信息
     * @param id
     * @return
     */
    Stu getStuInfo(int id);

    /**
     * 保存
     * @param stu
     */
    void saveStu(Stu stu);

    /**
     * 更新
     * @param stu
     */
    void updateStu(Stu stu);

    /**
     * 修改
     * @param id
     */
    void deleteStu(int id);
}
