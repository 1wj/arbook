package com.iweb.filter;

import com.iweb.settings.domain.Admint;
import com.iweb.settings.domain.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFiter implements  Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("进入登录过滤器");

        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp= (HttpServletResponse) servletResponse;

        String path = req.getServletPath();
        System.out.println("登录过滤器中的路径"+path);
        if("/login.jsp".equals(path) || "/settings/login.do".equals(path)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            HttpSession session = req.getSession();
            Admint admint2 = (Admint) session.getAttribute("admint2");
            if(admint2==null){
                resp.sendRedirect(req.getContextPath()+"/login.jsp");
            }else {
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }



    }
}
