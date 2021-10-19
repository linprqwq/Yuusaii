package com.lin.servlet;

import com.lin.pojo.UserInfo;
import com.lin.service.UserService;
import com.lin.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/login.do")
public class LoginServlet extends com.lin.servlet.BaseServlet {

    UserService userService =new UserServiceImpl();

    public void login(HttpServletRequest request, HttpServletResponse response) throws InvocationTargetException, IllegalAccessException, ServletException, IOException {
        //接收数据
        Map<String, String[]> map = request.getParameterMap();
        UserInfo userInfo =new UserInfo();
        BeanUtils.populate(userInfo,map);
        UserInfo userInfo1 = userService.queryuserbyloginnameandpwd(userInfo);
        if(userInfo1!=null){
            request.getSession().setAttribute("user",userInfo1);
            request.getRequestDispatcher("menu.do?method=showmenu").forward(request,response);
        }else{
            request.setAttribute("errmsg","账号或者密码错误!");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }



}
