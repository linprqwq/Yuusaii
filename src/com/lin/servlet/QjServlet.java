package com.lin.servlet;


import com.lin.dao.UserDao;
import com.lin.dao.impl.UserDaoImpl;
import com.lin.pojo.PageInfo;
import com.lin.pojo.Qj;
import com.lin.pojo.UserInfo;
import com.lin.service.QjService;
import com.lin.service.impl.QjServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/qj.do")
public class QjServlet extends com.lin.servlet.BaseServlet {

        QjService qjService=new QjServiceImpl();
    public void qj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        request.getRequestDispatcher("qj/qj.jsp").forward(request,response);
    }
    
    public void yy(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ParseException {
        Qj p=new Qj();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(p,map);
       /* String uid=request.getParameter("uid");
        String hid=request.getParameter("hid");
        String bname=request.getParameter("btime");
        String sname=request.getParameter("stime");

        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date bname1=null;

            Date time1=df.parse(bname);
            bname1=new java.sql.Date(time1.getTime());



        SimpleDateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sname1=null;

            Date time2=df1.parse(sname);
            sname1=new java.sql.Date(time2.getTime());*/




        /*p.setBtime(new Date());
        Date date1=new Date();
        date1.setDate(date1.getDate()+3);
        p.setStime(date1);*/
        qjService.ad(p);
        response.sendRedirect("qj/cg.jsp");
    }


    public void queryallqj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {


        UserDao userDao = new UserDaoImpl();
        ArrayList<UserInfo> listuser = userDao.showuser();
        request.setAttribute("listuser", listuser);

        Qj m=new Qj();
        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(m,map);

        //将当前登入uid转过去（用于判断）
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        m.setUid(userInfo.getId());


        int pagenum =1;
        int pagesize =5;
        try {
            pagenum = Integer.parseInt(request.getParameter("pagenum"));
        }catch (Exception e){
            pagenum=1;
        }

        PageInfo<Qj> pageInfo = qjService.selm1(m,pagenum,pagesize);
        /* HttpSession session=request.getSession();*/
        request.setAttribute("page",pageInfo);
        //跳转到角色列表页面
        request.getRequestDispatcher("qj/qjjr.jsp").forward(request,response);
    }

    public void spqj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {

        UserDao userDao = new UserDaoImpl();
        ArrayList<UserInfo> listuser = userDao.showuser();
        request.setAttribute("listuser", listuser);

        Qj m=new Qj();
        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(m,map);

        //将当前登入zid转过去（用于判断）
     /*UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        m.setZid(userInfo.getZid());*/

        int pagenum =1;
        int pagesize =5;
        try {
            pagenum = Integer.parseInt(request.getParameter("pagenum"));
        }catch (Exception e){
            pagenum=1;
        }

        PageInfo<Qj> pageInfo = qjService.selm(m,pagenum,pagesize);
        /* HttpSession session=request.getSession();*/
        request.setAttribute("page",pageInfo);

        request.getRequestDispatcher("qj/spqj.jsp").forward(request,response);
    }

    public void tg(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Qj r=new Qj();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(r,map);

        qjService.tg(r);
        response.sendRedirect("qj.do?method=spqj");
    }

    public void btg(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Qj r=new Qj();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(r,map);

        qjService.btg(r);
        response.sendRedirect("qj.do?method=spqj");

    }


    public void queryallspqj(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {


        UserDao userDao = new UserDaoImpl();
        ArrayList<UserInfo> listuser = userDao.showuser();
        request.setAttribute("listuser", listuser);

        Qj m=new  Qj();
        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(m,map);

        //将当前登入zid转过去（用于判断）
        UserInfo userInfo= (UserInfo) request.getSession().getAttribute("user");
        m.setZid(userInfo.getZid());

        int pagenum =1;
        int pagesize =5;
        try {
            pagenum = Integer.parseInt(request.getParameter("pagenum"));
        }catch (Exception e){
            pagenum=1;
        }

        PageInfo<Qj> pageInfo = qjService.selm3(m,pagenum,pagesize);
        /* HttpSession session=request.getSession();*/
        request.setAttribute("page",pageInfo);
        //跳转到角色列表页面
        request.getRequestDispatcher("qj/spqjjr.jsp").forward(request,response);
    }



}
