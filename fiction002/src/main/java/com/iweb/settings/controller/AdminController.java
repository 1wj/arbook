package com.iweb.settings.controller;

import com.iweb.settings.domain.Admint;
import com.iweb.settings.domain.Book;
import com.iweb.settings.domain.Classt;
import com.iweb.settings.service.AdminService;
import com.iweb.settings.service.BookService;
import com.iweb.settings.service.ClasstService;
import com.iweb.settings.service.impl.AdminServiceImpl;
import com.iweb.settings.service.impl.BookServiceImpl;
import com.iweb.settings.service.impl.ClasstServiceImpl;
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

public class AdminController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if("/settings/admin/selectList.do".equals(path)){
            selectList(req,resp);
        }else if("/settings/admin/selectById.do".equals(path)){
            selectById(req,resp);
        }else if("/settings/admin/save.do".equals(path)){
            save(req,resp);
        }else if("/settings/admin/editById.do".equals(path)){
            editById(req,resp);
        }else if("/settings/admin/deleteById.do".equals(path)){
            deleteById(req,resp);
        }else if("/settings/admin/chongzhi.do".equals(path)){
            chongzhi(req,resp);
        }

    }


    private void chongzhi(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入密码重置");
        String aid = req.getParameter("aid");
        String aname = req.getParameter("aname");
        String oldpa = req.getParameter("oldpa");
        String newpa2 = req.getParameter("newpa2");
        Map<String,Object> map= new HashMap<>();
        map.put("aid",aid);
        map.put("aname",aname);
        map.put("oldpa",oldpa);
        map.put("newpa2",newpa2);
        AdminService as= (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        Boolean flag=as.chongzhi(map);
        PrintJson.printJsonFlag(resp,flag);
        Map map1=new HashMap();
    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String aid = req.getParameter("aid");
        AdminService as= (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        Boolean flag=as.deleteById(aid);
       if(flag==true){
            req.getRequestDispatcher("/manager/manager_selectByPage.jsp").forward(req,resp);
       }
        else {
            resp.getWriter().print("删除失败");
       }
    }

    private void editById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入到edit页面");
        String aid = req.getParameter("aid");
        AdminService as= (AdminService) ServiceFactory.getService(new AdminServiceImpl());
        Admint admint=as.editById(aid);
        req.setAttribute("editadmint",admint);
        req.getRequestDispatcher("/manager/manager_toAdd.jsp").forward(req,resp);

    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入到save方法中");
        String aid = req.getParameter("aid");
        String aname = req.getParameter("aname");
        String anickname = req.getParameter("anickname");
        String apasswd = req.getParameter("apasswd");
        int  flagpd = Integer.valueOf(req.getParameter("flag"));
        if(flagpd==0){
            String sj= DateTimeUtil.getSysTime();
            Admint admint=new Admint();
            admint.setAid(aid);
            admint.setAname(aname);
            admint.setAnickname(anickname);
            admint.setApasswd(apasswd);
            admint.setAcreatetime(sj);
            AdminService as= (AdminService) ServiceFactory.getService(new AdminServiceImpl());
            Boolean flag=as.save(admint);
            PrintJson.printJsonFlag(resp,flag);
        }
        else {
            Admint admint=new Admint();
            admint.setAid(aid);
            admint.setAname(aname);
            admint.setAnickname(anickname);
            admint.setApasswd(apasswd);

            AdminService as= (AdminService) ServiceFactory.getService(new AdminServiceImpl());
            Boolean flag=as.updateById(admint);
            PrintJson.printJsonFlag(resp,flag);
        }

    }

    private void selectById(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入到根据id查单条记录");
        String aid = req.getParameter("aid");
        AdminService as=new AdminServiceImpl();
        Boolean flag=as.selectById(aid);
        PrintJson.printJsonFlag(resp,flag);
    }

    private void selectList(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入管理员的查询列表");
        String aid = req.getParameter("aid");
        String aname = req.getParameter("aname");
        String anickname = req.getParameter("anickname");
        String pageNoStr = req.getParameter("pageNo");
        int pageNo=Integer.valueOf(pageNoStr);
        int skipCount=(pageNo-1)*3;
        AdminService as=new AdminServiceImpl();
        Map<String,Object> map=new HashMap();
        map.put("aid",aid);
        map.put("aname",aname);
        map.put("anickname",anickname);
        map.put("num1",skipCount);
        map.put("num2",3);

        PageVO<Admint> vo=as.selectList(map);
        PrintJson.printJsonObj(resp,vo);

    }
}
