package service;

import entity.Grade;

import java.util.List;

public interface GradeService{
    //插入成绩
    void insertGrade(Grade g);
    //获取用户成绩信息
    List<Grade> getGradeList(int user_id);
    //删除成绩
    //修改成绩
}
