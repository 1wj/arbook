package com.iweb.settings.controller;

import com.iweb.settings.domain.*;
import com.iweb.settings.service.BookService;
import com.iweb.settings.service.UserService;
import com.iweb.settings.service.impl.BookServiceImpl;
import com.iweb.settings.service.impl.UserServiceImpl;
import com.iweb.settings.vo.PageVO;
import com.iweb.utils.DateTimeUtil;
import com.iweb.utils.PrintJson;
import com.iweb.utils.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入用户控制模块");
        String path = req.getServletPath();
        System.out.println(path);
        if("/settings/login.do".equals(path)){
            login(req,resp);
        }else if("/settings/user/selectList.do".equals(path)){
            selectList(req,resp);

        }else if("/settings/user/editById.do".equals(path)){
            editById(req,resp);

        }else if("/settings/user/save.do".equals(path)){
            save(req,resp);

        }else if("/settings/user/deleteById.do".equals(path)){
            deleteById(req,resp);

        }else if("/settings/user/collect/selectList.do".equals(path)){
            collectSelectList(req,resp);

        }else if("/settings/user/collect/deleteById.do".equals(path)){
            collectdeleteById(req,resp);

        }else if("/settings/user/history/selectList.do".equals(path)){
            historySelectList(req,resp);

        }else if("/settings/user/vip/selectList.do".equals(path)){
            vipSelectList(req,resp);
        }
    }

    private void vipSelectList(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入充值记录查询方法");
        String vipid = req.getParameter("vipid");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        String pageNoStr = req.getParameter("pageNo");

        int pageNo=Integer.valueOf(pageNoStr);
        int skipCount=(pageNo-1)*3;
        UserService us=new UserServiceImpl();
        Map<String,Object> map=new HashMap();

        map.put("vipid",vipid);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        map.put("num1",skipCount);
        map.put("num2",3);

        PageVO<Vipt> vo=us.vipSelectList(map);
        PrintJson.printJsonObj(resp,vo);
    }

    private void historySelectList(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入历史记录查询方法");
        String xsid = req.getParameter("xsid");
        String xsmc = req.getParameter("xsmc");
        String xszz = req.getParameter("xszz");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");

        String pageNoStr = req.getParameter("pageNo");
        int pageNo=Integer.valueOf(pageNoStr);
        int skipCount=(pageNo-1)*3;
        UserService us=new UserServiceImpl();
        Map<String,Object> map=new HashMap();

        map.put("xsid",xsid);
        map.put("xsmc",xsmc);
        map.put("xszz",xszz);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        map.put("num1",skipCount);
        map.put("num2",3);

        PageVO<Book_User> vo=us.historySelectList(map);
        PrintJson.printJsonObj(resp,vo);
    }

    private void collectdeleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("进入删除收藏方法");
        String collectId = req.getParameter("collectId");
        String status = req.getParameter("status");
        Map<String,Object> map=new HashMap<>();
        map.put("collectId",collectId);
        map.put("status",status);

        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        int i=us .collectdeleteById(map);
        if(i==1){
            resp.sendRedirect(req.getContextPath()+"/fictionUser/collect_selectByPage.jsp");
        }else {
            resp.getWriter().print("删除失败");
        }
    }

    private void collectSelectList(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入收藏方法");
        String xsid = req.getParameter("xsid");
        String xsmc = req.getParameter("xsmc");
        String xszz = req.getParameter("xszz");

        String pageNoStr = req.getParameter("pageNo");
        int pageNo=Integer.valueOf(pageNoStr);
        int skipCount=(pageNo-1)*3;
        UserService us=new UserServiceImpl();
        Map<String,Object> map=new HashMap();
        map.put("xsid",xsid);
        map.put("xsmc",xsmc);
        map.put("xszz",xszz);
        map.put("num1",skipCount);
        map.put("num2",3);
        PageVO<Book> vo=us.collectSelectList(map);
        PrintJson.printJsonObj(resp,vo);
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("进入删除用户方法");
        String userid = req.getParameter("userid");
        UserService us = (UserService) ServiceFactory.getService(new UserServiceImpl());
        int i=us.deleteById(userid);
        if(i==1){
            resp.sendRedirect(req.getContextPath()+"/fictionUser/fictionUser_selectByPage.jsp");
        }else {
            resp.getWriter().print("删除失败");
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入到修改保存对象方法");
        String yhid = req.getParameter("yhid");
        String yhnc = req.getParameter("yhnc");
        String yhtel = req.getParameter("yhtel");
        String yhvip = req.getParameter("yhvip");
        int  flagpd = Integer.valueOf(req.getParameter("flag"));

           User user=new User();
           user.setUserid(yhid);
           user.setUnickname(yhnc);
           user.setTel(yhtel);
           user.setRemaindays(yhvip);

            UserService us= (UserService) ServiceFactory.getService(new UserServiceImpl());
            //ClasstService cs=new ClasstServiceImpl();
            Boolean flag=us.update(user);

            PrintJson.printJsonFlag(resp,flag);

    }

    private void editById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入到编辑用户");
        String userid = req.getParameter("userid");
        UserService us=new UserServiceImpl();
        User user = us.editById(userid);
        req.setAttribute("edituser",user);
        req.getRequestDispatcher("/fictionUser/fictionUser_toEdit.jsp").forward(req,resp);


    }

    private void selectList(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入用户查询全部方法");
        String yhid = req.getParameter("yhid");
        String yhmc = req.getParameter("yhmc");
        String yhnc = req.getParameter("yhnc");
        String yhsj = req.getParameter("yhsj");

        String pageNoStr = req.getParameter("pageNo");
        int pageNo=Integer.valueOf(pageNoStr);

        int skipCount=(pageNo-1)*3;

        UserService us=new UserServiceImpl();

        Map<String,Object> map=new HashMap();
        map.put("yhid",yhid);
        map.put("yhmc",yhmc);
        map.put("yhnc",yhnc);
        map.put("yhsj",yhsj);
        map.put("num1",skipCount);
        map.put("num2",3);

        PageVO<User> vo=us.selectList(map);
        PrintJson.printJsonObj(resp,vo);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入login方法");
        String namestr = req.getParameter("namestr");
        String passwdstr = req.getParameter("passwdstr");
        /*User user=new User();
        user.setUname(namestr);
        user.setUpwd(passwdstr);*/
        Admint admint=new Admint();
        admint.setAname(namestr);
        admint.setApasswd(passwdstr);
        UserService us=new UserServiceImpl();
      //  User user2=us.login(user);
        Admint admint2=us.login(admint);
        Boolean flag=false;
        if (admint2!=null){
            flag=true;

        }
        req.getSession().setAttribute("admint2",admint2);
        PrintJson.printJsonFlag(resp,flag);
    }
}
