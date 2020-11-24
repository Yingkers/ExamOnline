package dao.impl;

import util.ConnectMysql;
import dao.SingleDao;
import entity.Single;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SingleDaoImpl extends ConnectMysql implements SingleDao{
    private String sql;
    private PreparedStatement statement;
    private ResultSet resultSet;
    private List list;

    public SingleDaoImpl(){
        super();
    }

    //获取题目列表
    @Override
    public List<Single> getSingleList(){
        //准备对应的sql语句
        this.sql="select * from single";
        try {
            this.statement=conn.prepareStatement(this.sql);
            //取得结果集
            this.resultSet=this.statement.executeQuery();
            //将结果集放入列表
            this.list=new ArrayList<Single>();
            while (this.resultSet.next()) {
                Single single = new Single();
                single.setSingle_id(this.resultSet.getInt("single_id"));
                single.setSubject(this.resultSet.getString("subject"));
                single.setOption_A(this.resultSet.getString("option_A"));
                single.setOption_B(this.resultSet.getString("option_B"));
                single.setOption_C(this.resultSet.getString("option_C"));
                single.setOption_D(this.resultSet.getString("option_D"));
                single.setAnswer(this.resultSet.getString("answer"));
                single.setPaper(this.resultSet.getString("paper"));
                this.list.add(single);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.list;
    }

    //通过科目获取题目列表
    @Override
    public List<Single> getSingleListByPaper(String paper){
        //准备对应的sql语句
        this.sql="select * from single where paper=?";
        try {
            this.statement=conn.prepareStatement(this.sql);
            //设置参数
            this.statement.setString(1,paper);
            //取得结果集
            this.resultSet=this.statement.executeQuery();
            //将结果集放入列表
            this.list=new ArrayList<Single>();
            while (this.resultSet.next()) {
                Single single = new Single();
                single.setSingle_id(this.resultSet.getInt("single_id"));
                single.setSubject(this.resultSet.getString("subject"));
                single.setOption_A(this.resultSet.getString("option_A"));
                single.setOption_B(this.resultSet.getString("option_B"));
                single.setOption_C(this.resultSet.getString("option_C"));
                single.setOption_D(this.resultSet.getString("option_D"));
                single.setAnswer(this.resultSet.getString("answer"));
                single.setPaper(this.resultSet.getString("paper"));
                this.list.add(single);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.list;
    }

    //获取科目列表
    @Override
    public List<String> getSubjectList(){
        //准备对应的sql语句
        this.sql="select distinct paper from single";
        try {
            this.statement=conn.prepareStatement(sql);
            //获得结果集
            this.resultSet=this.statement.executeQuery();
            //将结果放入列表
            this.list=new ArrayList<String>();
            while(this.resultSet.next()){
                list.add(this.resultSet.getString("paper"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.list;
    }

    //通过科目获取答案列表
    @Override
    public List<String> getAnswerListByPaper(String paper){
        //准备对应的sql语句
        this.sql="select answer from single where paper=?";
        try {
            this.statement=conn.prepareStatement(sql);
            //设置参数
            this.statement.setString(1,paper);
            //获得结果集
            this.resultSet=this.statement.executeQuery();
            //将结果放入列表
            this.list=new ArrayList<String>();
            while(this.resultSet.next()){
                list.add(this.resultSet.getString("answer"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return this.list;
    }
}
