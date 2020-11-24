package dao.impl;

import util.ConnectMysql;
import dao.UserDao;
import entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl extends ConnectMysql implements UserDao{
    private String sql;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public UserDaoImpl(){
        super();
    }

    //通过用户名查询用户信息
    @Override
    public User getUserByUsername(String username){
        User user=new User();
        //准备对应的sql语句
        this.sql="select * from user where username=?";
        try {
            this.statement=conn.prepareStatement(this.sql);
            //设置参数
            this.statement.setString(1,username);
            //获得结果集
            this.resultSet=this.statement.executeQuery();
            //讲结果集内容给用户
            while(this.resultSet.next()){
                user.setUser_id(this.resultSet.getInt("user_id"));
                user.setUsername(this.resultSet.getString("username"));
                user.setPassword(this.resultSet.getString("password"));
                user.setName(this.resultSet.getString("name"));
                user.setTelephone(this.resultSet.getString("telephone"));
                user.setSex(this.resultSet.getString("sex"));
                user.setAge(this.resultSet.getInt("age"));
                user.setRole(this.resultSet.getString("role"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    //添加用户
    @Override
    public void insertUser(User user){
        //准备对应的sql语句
        this.sql="insert into user values(?,?,?,?,?,?,?,?)";
        try {
            this.statement=conn.prepareStatement(this.sql);
            //设置参数
            this.statement.setInt(1,user.getUser_id());
            this.statement.setString(2,user.getUsername());
            this.statement.setString(3,user.getPassword());
            this.statement.setString(4,user.getName());
            this.statement.setString(5,user.getTelephone());
            this.statement.setString(6,user.getSex());
            this.statement.setInt(7,user.getAge());
            this.statement.setString(8,user.getRole());
            //执行
            this.statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
