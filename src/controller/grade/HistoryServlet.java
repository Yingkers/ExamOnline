package controller.grade;

import entity.Grade;
import entity.User;
import service.GradeService;
import service.impl.GradeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "HistoryServlet",urlPatterns ="/history")
public class HistoryServlet extends HttpServlet{
    GradeService gradeService=new GradeServiceImpl();

    @Override
    protected void service(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        //获取session获取当前用户信息
        User user=(User)req.getSession().getAttribute("User");
        //System.out.println(user);
        List<Grade> gradeList=this.gradeService.getGradeList(user.getUser_id());
        //System.out.println(gradeList);
        req.setAttribute("gradeList",gradeList);
        req.getRequestDispatcher("WEB-INF/Exam/resultTable.jsp").forward(req,resp);
    }
}
