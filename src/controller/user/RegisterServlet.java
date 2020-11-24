package controller.user;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet (name = "RegisterServlet",urlPatterns = "/register")
public class RegisterServlet extends HttpServlet{

    UserService userService=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        //接收请求，调用服务，跳转界面
        //将前端的数据整合在一个user对象中
        User user=new User();
        user.setUsername(req.getParameter("username"));
        user.setPassword(req.getParameter("password"));
        user.setName(req.getParameter("name"));
        user.setAge(Integer.valueOf(req.getParameter("age")));
        user.setSex(req.getParameter("sex"));
        user.setRole(req.getParameter("role"));
        user.setTelephone(req.getParameter("telephone"));
        //System.out.println(user);

        //调用服务
        this.userService.insertUser(user);
        //跳转界面
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
