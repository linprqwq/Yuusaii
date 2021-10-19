package com.lin.servlet;

import com.lin.pojo.MenuInfo;
import com.lin.pojo.PageInfo;
import com.lin.pojo.UserInfo;
import com.lin.service.MenuService;
import com.lin.service.impl.MenuServiceImpl;
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

@WebServlet("/menu.do")
public class MenuServlet extends BaseServlet{

    MenuService menuService =new MenuServiceImpl();

    /**
     * 查询到所有菜单数据，跳转到index.jsp页面 显示
     * @param request
     * @param response
     */
    public void showmenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //根据角色id找   登录成功时，保存的session中有用户user
        UserInfo userInfo = (UserInfo) request.getSession().getAttribute("user");

        //获取所有菜单数据
        List<MenuInfo> list = menuService.querymenusbyrid(userInfo.getRid());

        //跳转首页
        request.getSession().setAttribute("menus",list);
        request.getRequestDispatcher("main.jsp").forward(request,response);
    }


    /**
     * 查询所有的菜单数据 跳转到菜单列表页面
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void queryallmenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, InvocationTargetException, IllegalAccessException {
        //查询到所有的菜单数据
        MenuInfo m=new MenuInfo();
        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(m,map);

        int pagenum =1;
        int pagesize =5;
        try {
            pagenum = Integer.parseInt(request.getParameter("pagenum"));
        }catch (Exception e){
            pagenum=1;
        }

        PageInfo<MenuInfo> pageInfo = menuService.selm(m,pagenum,pagesize);
       HttpSession session=request.getSession();
        session.setAttribute("page",pageInfo);

        //数据不显示菜单处理
        List<MenuInfo> list = menuService.queryallmenus2();
        request.getSession().setAttribute("listadup",list);
        //跳转到菜单列表页面
        request.getRequestDispatcher("menu/menulist.jsp").forward(request,response);
    }

    public void ad(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        MenuInfo m=new MenuInfo();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(m,map);
        menuService.ad(m);
        response.sendRedirect("menu.do?method=queryallmenu");

    }

    public void selById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id =request.getParameter("id");
        MenuInfo m=menuService.selById(Integer.parseInt(id));
        request.setAttribute("m",m);
        request.getRequestDispatcher("menu/editmenu.jsp").forward(request, response);
    }

    public void upd(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, IOException {
        MenuInfo m=new MenuInfo();

        Map<String, String[]> map = request.getParameterMap();

        BeanUtils.populate(m,map);
        menuService.xg(m);
        response.sendRedirect("menu.do?method=queryallmenu");
    }

    public void del(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        menuService.del(Integer.parseInt(id));
        response.sendRedirect("menu.do?method=queryallmenu");
    }


    public void hf(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<MenuInfo> list = menuService.queryallmenus2();
        request.setAttribute("list",list);
        request.getRequestDispatcher("menu/menuhf.jsp").forward(request,response);
    }

    public void ff(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id=request.getParameter("id");
        menuService.ff(Integer.parseInt(id));
        response.sendRedirect("menu.do?method=hf");
    }


}
