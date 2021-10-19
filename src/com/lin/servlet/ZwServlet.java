package com.lin.servlet;



import com.lin.pojo.PageInfo;
import com.lin.pojo.Zw;
import com.lin.service.impl.ZwServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/zw.do")
public class ZwServlet extends com.lin.servlet.BaseServlet {

        EmailServlet.ZwService zwService=new ZwServiceImpl();

    public void queryallzw(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //查询到所有的角色数据
        Zw z=new Zw();
        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(z,map);

        int pagenum =1;
        int pagesize =5;
        try {
            pagenum = Integer.parseInt(request.getParameter("pagenum"));
        }catch (Exception e){
            pagenum=1;
        }

        PageInfo<Zw> pageInfo = zwService.selm(z,pagenum,pagesize);
        /*HttpSession session=request.getSession();*/
        request.setAttribute("page",pageInfo);
        //跳转到角色列表页面
        request.getRequestDispatcher("zw/zwlist.jsp").forward(request,response);

    }

    public void ad(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
       Zw z=new Zw();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(z,map);
        zwService.ad(z);
        response.sendRedirect("zw.do?method=queryallzw");

    }

    public void selById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        Zw r=zwService.selById(Integer.parseInt(id));
        request.setAttribute("r",r);
        request.getRequestDispatcher("zw/editzw.jsp").forward(request, response);
    }

    public void upd(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        Zw z=new Zw();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(z,map);
        zwService.xg(z);
        response.sendRedirect("zw.do?method=queryallzw");

    }

    public void del(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id=request.getParameter("id");
        zwService.del(Integer.parseInt(id));
        response.sendRedirect("zw.do?method=queryallzw");
    }





}
