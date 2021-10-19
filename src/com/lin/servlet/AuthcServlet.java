package com.lin.servlet;

import com.lin.pojo.MenuInfo;
import com.lin.pojo.RoleInfo;
import com.lin.service.MenuRoleService;
import com.lin.service.MenuService;
import com.lin.service.RoleService;
import com.lin.service.impl.MenuRoleServiceImpl;
import com.lin.service.impl.MenuServiceImpl;
import com.lin.service.impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/authc.do")
public class AuthcServlet extends com.lin.servlet.BaseServlet {

    RoleService roleService = new RoleServiceImpl();
    MenuService menuService = new MenuServiceImpl();
    MenuRoleService menuRoleService = new MenuRoleServiceImpl();

    /**
     * 查询角色信息，菜单信息，供权限页面显示
     *
     * @param request
     * @param response
     */
    public void showauthc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //查询角色信息集合
        List<RoleInfo> roles = roleService.queryallrole();

        //查询菜单信息集合  接收页面角色id(rid)进去
        int  rid = -1;
        try {
            rid = Integer.parseInt(request.getParameter("rid"));
        }catch (Exception e){
            rid=-1;
        }

        List<MenuInfo> menus = menuService.queryallmenus(rid);



        //传递数据
        request.setAttribute("rid", rid);
        request.setAttribute("roles", roles);
        request.setAttribute("menus", menus);

        //跳转页面
        request.getRequestDispatcher("authc/authc.jsp").forward(request, response);

    }

    /**
     * 将页面角色id，菜单id，保存到权限表
     *
     * @param request
     * @param response
     */
    public void setauthc(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取数据（map 既有一个rid，又有一个数组，包含了页面选中的所有的菜单id）
        Map<String, String[]> map = request.getParameterMap();
        //传递数据  service
        menuRoleService.setauthc(map);
        //跳转页面
        response.sendRedirect("authc.do?method=showauthc");
    }



    /*public void cxbyrid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //根据rid查询菜单
        String rid=request.getParameter("rid");
        List<MenuInfo> mbyid=menuService.querymenusbyrid(Integer.parseInt(rid));
        request.setAttribute("mr",mbyid);
        request.getRequestDispatcher("authc.do?method=showauthc").forward(request, response);

    }
*/

}
