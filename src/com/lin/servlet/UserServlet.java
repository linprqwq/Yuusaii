package com.lin.servlet;

import com.lin.dao.RoleDao;
import com.lin.dao.ZwDao;
import com.lin.dao.impl.RoleDaoImpl;
import com.lin.dao.impl.ZwDaoImpl;
import com.lin.pojo.PageInfo;
import com.lin.pojo.RoleInfo;
import com.lin.pojo.UserInfo;
import com.lin.pojo.Zw;
import com.lin.service.UserService;
import com.lin.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

@WebServlet("/user.do")
public class UserServlet extends com.lin.servlet.BaseServlet {
    UserService userService=new UserServiceImpl();
    /**
     * 查询所有的用户数据 跳转到用户列表页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void queryalluser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        RoleDao roleDao=new RoleDaoImpl();
        List<RoleInfo> list=roleDao.queryallrole();
        HttpSession session=request.getSession();
        session.setAttribute("list",list);

        ZwDao zwDao=new ZwDaoImpl();
        List<Zw> list1=zwDao.queryallzw();
        HttpSession session1=request.getSession();
        session1.setAttribute("list1",list1);

        //查询到所有的用户数据
        UserInfo u=new UserInfo();
        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(u,map);

        int pagenum =1;
        int pagesize =5;
        try {
            pagenum = Integer.parseInt(request.getParameter("pagenum"));
        }catch (Exception e){
            pagenum=1;
        }

        PageInfo<UserInfo> pageInfo = userService.selm(u,pagenum,pagesize);
        /*HttpSession session=request.getSession();*/
        request.setAttribute("page",pageInfo);
        //request.setAttribute("users",list);
        //跳转到用户列表页面
        request.getRequestDispatcher("user/userlist.jsp").forward(request,response);
    }


    public void ad(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        UserInfo u=new UserInfo();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(u,map);
        userService.ad(u);
        response.sendRedirect("user.do?method=queryalluser");

    }

    public void selById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        UserInfo u=userService.selById(Integer.parseInt(id));
        request.setAttribute("u",u);
        request.getRequestDispatcher("user/edituser.jsp").forward(request, response);
    }

    public void up(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
       UserInfo u=new UserInfo();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(u,map);
        userService.xg(u);
        response.sendRedirect("user.do?method=queryalluser");

    }

    public void del(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id=request.getParameter("id");
        userService.del(Integer.parseInt(id));
        response.sendRedirect("user.do?method=queryalluser");
    }

    public void zx(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session=request.getSession();
        //注销代码
        session.invalidate();
        response.sendRedirect("login.jsp");
    }
}
