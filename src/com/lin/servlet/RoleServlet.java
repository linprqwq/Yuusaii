package com.lin.servlet;


import com.lin.pojo.PageInfo;
import com.lin.pojo.RoleInfo;
import com.lin.service.RoleService;
import com.lin.service.impl.RoleServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/role.do")
public class RoleServlet extends com.lin.servlet.BaseServlet {

    RoleService roleService=new RoleServiceImpl();

    public void queryallrole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //查询到所有的角色数据
       RoleInfo r=new RoleInfo();
        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(r,map);

        int pagenum =1;
        int pagesize =5;
        try {
            pagenum = Integer.parseInt(request.getParameter("pagenum"));
        }catch (Exception e){
            pagenum=1;
        }

        PageInfo<RoleInfo> pageInfo = roleService.selm(r,pagenum,pagesize);
        request.setAttribute("page",pageInfo);
        //跳转到角色列表页面
        request.getRequestDispatcher("role/rolelist.jsp").forward(request,response);

    }

    public void ad(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        RoleInfo r=new RoleInfo();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(r,map);
        roleService.ad(r);
        response.sendRedirect("role.do?method=queryallrole");

    }

    public void selById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        RoleInfo r=roleService.selById(Integer.parseInt(id));
        request.setAttribute("r",r);
        request.getRequestDispatcher("role/editrole.jsp").forward(request, response);
    }

    public void upd(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        RoleInfo r=new RoleInfo();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(r,map);
        roleService.xg(r);
        response.sendRedirect("role.do?method=queryallrole");

    }

    public void del(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String id=request.getParameter("id");
        roleService.del(Integer.parseInt(id));
        response.sendRedirect("role.do?method=queryallrole");
    }




}
