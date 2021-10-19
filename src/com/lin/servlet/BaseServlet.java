package com.lin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

//自己开发出来的基类   以后所有的servlet都继承他
public class
BaseServlet extends HttpServlet {

//重写service方法  不要父类的 执行doGet、doPost方法了
    //自己写实现
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        try {
            //获取method参数的值(将要执行的方法名字)
            String methodname =req.getParameter("method");
            //临时方案  如果访问servlet没有给method，默认访问查询方法
            if(methodname==null || "".equals(methodname)){
                methodname="queryallnews";
            }

            //利用反射技术  根据方法名找到Method
            Class cls =this.getClass();

            Method method = cls.getDeclaredMethod(methodname,
                    HttpServletRequest.class,HttpServletResponse.class);

            //执行Method
            method.invoke(this,req,resp);

        }catch (Exception e){

        }


    }
}
