package dao;

import entity.User;

public interface UserDao{
    //通过用户名查询用户
    User getUserByUsername(String username);
    //添加用户
    void insertUser(User user);
}
