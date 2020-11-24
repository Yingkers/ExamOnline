package controller.single;

import entity.Grade;
import entity.User;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

@WebServlet (name = "CheckServlet",urlPatterns = "/check")
public class CheckServlet extends HttpServlet{
    SingleService singleService=new SingleServiceImpl();
    GradeService gradeService=new GradeServiceImpl();

    @Override
    protected void service(HttpServletRequest req , HttpServletResponse resp) throws ServletException, IOException{
        req.setCharacterEncoding("utf-8");
        /*1.获取用户传递的数据（试题）
        2.取出数据库中对应科目的答案
        3.答案核对
        4.计算分数
        5.（数据传递）跳转界面
         */
        //获取科目名
        String paper=req.getParameter("paper");
        //获取所有参数名
        Enumeration<String> parameter=req.getParameterNames();
        //取出数据库中对应科目的答案
        List<String> answerList=this.singleService.getAnswerListByPaper(paper);
        //用户答案收集器
        List<String> userAnswerList=new ArrayList<>();
        //正确答案计数
        int count=0;
        //parameter.hasMoreElements(),表示是否还有下一个值
        while (parameter.hasMoreElements()){
            //获取当前题号
            String number=parameter.nextElement();
            try{
                //字符串题号转int
                int index=Integer.parseInt(number);
                //获取用户答案
                String userAnswer=req.getParameter(number);
                //答案核对
                if(userAnswer.equals(answerList.get(index))) count++;
                userAnswerList.add(userAnswer);
            }catch (NumberFormatException e){
                continue;
            }
        }
        //分数
        int fraction= count*(100/answerList.size());
        //取出session中存入的user信息
        User user =(User)req.getSession().getAttribute("User");
        Grade g=new Grade();
        g.setUser_id(user.getUser_id());
        g.setPaper(paper);
        g.setScore(fraction);
        g.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        //调用gradeService服务，以方便完成我们的成绩录入
        this.gradeService.insertGrade(g);
        //分数，用户答案，正确答案 传递给jsp
        req.setAttribute("fraction",fraction);
        req.setAttribute("userAnswerList",userAnswerList);
        req.setAttribute("answerList",answerList);
        //跳转新jsp
        req.getRequestDispatcher("WEB-INF/Exam/result.jsp").forward(req,resp);
    }
}
