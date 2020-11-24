package controller.single;

import entity.Single;
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

@WebServlet (name = "GetParperListServlet",urlPatterns = "/getPaperList")
public class GetParperListServlet extends HttpServlet{

    SingleService singleService=new SingleServiceImpl();
    GradeService gradeService=new GradeServiceImpl();

    @Override
    protected void service(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        //获取jsp传递的科目名
        String paper=req.getParameter("paper");
        //调用服务层的对应方法,并创建List接受服务层返回的数据
        List<Single> list=  this.singleService.getSingleListByPaper(paper);
        //向新JSP页面返回数据（传递参数）
        req.setAttribute("paperList",list);
        //向新jsp页面传递科目名
        req.setAttribute("paper",paper);
        //跳转指定JSP页面
        req.getRequestDispatcher("WEB-INF/Exam/exam1.jsp").forward(req,resp);
    }
}
