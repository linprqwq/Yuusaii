package com.lin.servlet;

import com.lin.dao.MeetDao;
import com.lin.dao.UserDao;
import com.lin.dao.impl.MeetDaoImpl;
import com.lin.dao.impl.UserDaoImpl;
import com.lin.pojo.*;
import com.lin.service.MeetService;
import com.lin.service.ProMeetService;
import com.lin.service.impl.MeetServiceImpl;
import com.lin.service.impl.ProMeetServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet("/promeet.do")
public class ProMeetServlet extends com.lin.servlet.BaseServlet {
    MeetService meetService=new MeetServiceImpl();
    ProMeetService proMeetService=new ProMeetServiceImpl();
    public void promeet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //查询到所有的角色数据
        Meet m=new Meet();
        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(m,map);

        int pagenum =1;
        int pagesize =5;
        try {
            pagenum = Integer.parseInt(request.getParameter("pagenum"));
        }catch (Exception e){
            pagenum=1;
        }

        PageInfo<Meet> pageInfo = meetService.selm(m,pagenum,pagesize);
        /* HttpSession session=request.getSession();*/
        request.setAttribute("page",pageInfo);

        request.getRequestDispatcher("promeet/yymeet.jsp").forward(request,response);
    }


    public void yy(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException, ParseException {
        ProMeet p=new ProMeet();

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
        proMeetService.ad(p);
        response.sendRedirect("promeet/cg.jsp");
    }


    public void queryallpromeet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        MeetDao meetDao=new MeetDaoImpl();
        ArrayList<Meet> listmeet=meetDao.cxmeet();
        HttpSession session=request.getSession();
        request.setAttribute("listmeet",listmeet);


        UserDao userDao = new UserDaoImpl();
        ArrayList<UserInfo> listuser = userDao.showuser();
        request.setAttribute("listuser", listuser);

        ProMeet m=new ProMeet();
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

        PageInfo<ProMeet> pageInfo = proMeetService.selm2(m,pagenum,pagesize);
        /* HttpSession session=request.getSession();*/
        request.setAttribute("page",pageInfo);
        //跳转到角色列表页面
        request.getRequestDispatcher("promeet/yymeetjr.jsp").forward(request,response);
    }

    public void spmeet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        MeetDao meetDao=new MeetDaoImpl();
        ArrayList<Meet> listmeet=meetDao.cxmeet();
        HttpSession session=request.getSession();
        request.setAttribute("listmeet",listmeet);


        UserDao userDao = new UserDaoImpl();
        ArrayList<UserInfo> listuser = userDao.showuser();
        request.setAttribute("listuser", listuser);

        ProMeet m=new ProMeet();
        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(m,map);

        int pagenum =1;
        int pagesize =5;
        try {
            pagenum = Integer.parseInt(request.getParameter("pagenum"));
        }catch (Exception e){
            pagenum=1;
        }

        PageInfo<ProMeet> pageInfo = proMeetService.selm1(m,pagenum,pagesize);
        /* HttpSession session=request.getSession();*/
        request.setAttribute("page",pageInfo);

        request.getRequestDispatcher("promeet/spmeet.jsp").forward(request,response);
    }

    public void tg(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        ProMeet r=new ProMeet();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(r,map);
      /*  r.setSptime(new Date());*/
        proMeetService.tg(r);
        response.sendRedirect("promeet.do?method=spmeet");

    }

    public void btg(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        ProMeet r=new ProMeet();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(r,map);
       /* r.setSptime(new Date());*/
        proMeetService.btg(r);
        response.sendRedirect("promeet.do?method=spmeet");

    }


    public void queryallspmeet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        MeetDao meetDao=new MeetDaoImpl();
        ArrayList<Meet> listmeet=meetDao.cxmeet();
        HttpSession session=request.getSession();
        request.setAttribute("listmeet",listmeet);


        UserDao userDao = new UserDaoImpl();
        ArrayList<UserInfo> listuser = userDao.showuser();
        request.setAttribute("listuser", listuser);

        ProMeet m=new ProMeet();
        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(m,map);

        int pagenum =1;
        int pagesize =5;
        try {
            pagenum = Integer.parseInt(request.getParameter("pagenum"));
        }catch (Exception e){
            pagenum=1;
        }

        PageInfo<ProMeet> pageInfo = proMeetService.selm(m,pagenum,pagesize);
        /* HttpSession session=request.getSession();*/
        request.setAttribute("page",pageInfo);
        //跳转到角色列表页面
        request.getRequestDispatcher("promeet/spmeetjr.jsp").forward(request,response);
    }


}
