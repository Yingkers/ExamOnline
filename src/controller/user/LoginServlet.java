package controller.user;

import entity.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet{

    UserService userService=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        //接收请求，调用服务，跳转界面
        String username=req.getParameter("username");
        String userPassword=req.getParameter("password");
        //调用服务，取出对应用户名的用户id与密码
        User user=this.userService.getUserByUsername(username);
        //判断用户是否存在
        if(user.getUsername()!=null){
            //判断密码是否一致
            if(user.getPassword().equals(userPassword)){
                //使用Session存入user信息
                HttpSession session=req.getSession();
                session.setAttribute("User",user);
                req.setAttribute("userName",username);
                req.getRequestDispatcher("WEB-INF/Exam/studentIndex.jsp").forward(req,resp);
            }
        }
        //登录失败，仍在原界面
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
