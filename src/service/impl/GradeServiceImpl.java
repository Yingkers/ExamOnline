package service.impl;

import dao.GradeDao;
import dao.impl.GradeDaoImpl;
import entity.Grade;
import service.GradeService;

import java.util.List;

public class GradeServiceImpl implements GradeService{
    GradeDao gradeDao = new GradeDaoImpl();

    //插入成绩
    @Override
    public void insertGrade(Grade g){
        this.gradeDao.insertGrade(g);
    }

    //获取成绩列表
    @Override
    public List<Grade> getGradeList(int user_id){
        return this.gradeDao.getGradeList(user_id);
    }
}
