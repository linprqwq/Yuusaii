package com.lin.servlet;

import com.lin.pojo.Meet;
import com.lin.pojo.PageInfo;
import com.lin.service.MeetService;
import com.lin.service.impl.MeetServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/meet.do")
public class MeetServlet extends com.lin.servlet.BaseServlet {
    MeetService meetService=new MeetServiceImpl();
    public void queryallmeet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
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
        //跳转到角色列表页面
        request.getRequestDispatcher("meet/meetlist.jsp").forward(request,response);

    }

    public void ad(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Meet m=new Meet();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(m,map);
        meetService.ad(m);
        response.sendRedirect("meet.do?method=queryallmeet");

    }

    public void selById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        Meet me=meetService.selById(Integer.parseInt(id));
        request.setAttribute("me",me);
        request.getRequestDispatcher("meet/editmeet.jsp").forward(request, response);
    }

    public void upd(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Meet m=new Meet();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(m,map);
        meetService.xg(m);
        response.sendRedirect("meet.do?method=queryallmeet");

    }

    public void del(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id=request.getParameter("id");
        meetService.del(Integer.parseInt(id));
        response.sendRedirect("meet.do?method=queryallmeet");
    }




}
