package controller.single;

import service.GradeService;
import service.SingleService;
import service.impl.GradeServiceImpl;
import service.impl.SingleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "GetSubjectListServlet",urlPatterns = "/getSubjectList")
public class GetSubjectListServlet extends HttpServlet{

    SingleService singleService=new SingleServiceImpl();
    GradeService gradeService=new GradeServiceImpl();

    @Override
    protected void service(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        //接收处理后的数据
        List<String> list= this.singleService.getSubjectList();
        //数据整理（携带）
        req.setAttribute("subjectList",list);
        //跳转
        req.getRequestDispatcher("WEB-INF/Exam/SubjectList.jsp").forward(req,resp);
    }
}
