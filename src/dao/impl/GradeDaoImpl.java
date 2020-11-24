package dao.impl;

import util.ConnectMysql;
import dao.GradeDao;
import entity.Grade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class GradeDaoImpl extends ConnectMysql implements GradeDao{
    private String sql;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private List<Grade> gradeList;

    public GradeDaoImpl(){
        super();
    }

    //添加成绩
    @Override
    public void insertGrade(Grade g){
        //设置对应的sql语句
        this.sql="insert into grade values(?,?,?,?,?)";
        try {
            this.statement=conn.prepareStatement(this.sql);
            //添加参数
            this.statement.setInt(1,g.getGrade_id());
            this.statement.setInt(2,g.getUser_id());
            this.statement.setString(3,g.getPaper());
            this.statement.setInt(4,g.getScore());
            this.statement.setString(5,g.getTime().toString());
            //执行语句
            this.statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //查询用户成绩信息
    @Override
    public List<Grade> getGradeList(int user_id){
        //设置对应的sql语句
       this.sql="select * from grade where user_id=? order by time desc";
        try {
            this.statement=conn.prepareStatement(sql);
            //添加参数
            this.statement.setInt(1,user_id);
            //取得结果集
            this.resultSet=this.statement.executeQuery();
            //将结果放入列表中
            this.gradeList= new ArrayList<>();
            while(this.resultSet.next()){
                Grade grade=new Grade();
                grade.setGrade_id(this.resultSet.getInt("grade_id"));
                grade.setUser_id(this.resultSet.getInt("user_id"));
                grade.setPaper(this.resultSet.getString("paper"));
                grade.setScore(this.resultSet.getInt("score"));
                grade.setTime(this.resultSet.getString("time"));
                this.gradeList.add(grade);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.gradeList;
    }
}
