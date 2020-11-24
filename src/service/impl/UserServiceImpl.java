package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.UserService;

public class UserServiceImpl implements UserService{
    UserDao userDao=new UserDaoImpl();

    //通过用户名获取用户信息
    @Override
    public User getUserByUsername(String username){
        return this.userDao.getUserByUsername(username);
    }

    //添加用户
    @Override
    public void insertUser(User user){
        this.userDao.insertUser(user);
    }
}
