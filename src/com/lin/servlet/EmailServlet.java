package com.lin.servlet;
import com.lin.dao.UserDao;
import com.lin.dao.impl.UserDaoImpl;
import com.lin.pojo.Email;
import com.lin.pojo.PageInfo;
import com.lin.pojo.UserInfo;
import com.lin.pojo.Zw;
import com.lin.service.EmailService;
import com.lin.service.impl.EmailServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

@WebServlet("/ema.do")
public class EmailServlet extends com.lin.servlet.BaseServlet {
            EmailService emailService=new EmailServiceImpl();
    public void xj(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException, ServletException {
        Email e=new Email();
        Map<String, String[]> map = request.getParameterMap();
        BeanUtils.populate(e,map);
        e.setSendtime(new Date());
        e.setState(0);
        emailService.xj(e);
        request.getRequestDispatcher("email/sendemail.jsp").forward(request,response);
    }
    public void showxj(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException, ServletException {
        UserDao userDao = new UserDaoImpl();
        ArrayList<UserInfo> listuser = userDao.showuser();
        HttpSession session = request.getSession();
        session.setAttribute("listuser", listuser);
        request.getRequestDispatcher("email/sendemail.jsp").forward(request,response);
    }
    public void receiveemail(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException, ServletException {
        ArrayList<Email>  list=emailService.sj();
        /*HttpSession session=request.getSession();*/
        request.setAttribute("list1",list);
        request.getRequestDispatcher("email/sj.jsp").forward(request,response);
    }
    public void sc(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException, ServletException {
            String id=request.getParameter("id");
            emailService.sc(Integer.parseInt(id));
            response.sendRedirect("ema.do?method=receiveemail");
    }

    public void hf(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException, ServletException {
        String id=request.getParameter("id");
        emailService.hf(Integer.parseInt(id));
        response.sendRedirect("ema.do?method=recoveremail");
    }

    public void recoveremail(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException, ServletException {
        ArrayList<Email>  list=emailService.sj();
        /*HttpSession session=request.getSession();*/
        request.setAttribute("list2",list);
        request.getRequestDispatcher("email/hs.jsp").forward(request,response);
    }


    public void sendemail(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException, ServletException {
        ArrayList<Email>  list=emailService.sj();
        /*HttpSession session=request.getSession();*/
        request.setAttribute("list3",list);
        request.getRequestDispatcher("email/fj.jsp").forward(request,response);
    }

    public void zsc(HttpServletRequest request, HttpServletResponse response) throws IOException, InvocationTargetException, IllegalAccessException, ServletException {
        String id=request.getParameter("id");
        emailService.zsc(Integer.parseInt(id));
        response.sendRedirect("ema.do?method=recoveremail");
    }


    public static interface ZwService {

        public PageInfo<Zw> selm(Zw r, int pagenum, int pagesize);

        public boolean ad(Zw r);

        public  Zw selById(int id);

        public  boolean xg(Zw r);

        public  boolean del(int id);
    }
}
