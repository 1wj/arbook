package com.iweb.settings.controller;

import com.iweb.settings.domain.Classt;
import com.iweb.settings.domain.Messaget;
import com.iweb.settings.service.ClasstService;
import com.iweb.settings.service.MessageService;
import com.iweb.settings.service.impl.ClasstServiceImpl;
import com.iweb.settings.service.impl.MessageServiceImpl;
import com.iweb.settings.vo.PageVO;
import com.iweb.utils.DateTimeUtil;
import com.iweb.utils.PrintJson;
import com.iweb.utils.ServiceFactory;
import com.iweb.utils.UUIDUtil;
import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClasstController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入到类别模块");
        String path = req.getServletPath();
        System.out.println(path);
        if("/settings/selectList.do".equals(path)){
            selectList(req,resp);
        }if("/settings/save.do".equals(path)){
            save(req,resp);
        }if("/settings/selectById.do".equals(path)){
            selectById(req,resp);
        }if("/settings/editById.do".equals(path)){
            editById(req,resp);
        }if("/settings/deleteById.do".equals(path)){
            deleteById(req,resp);
        }
    }


    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("进入到类别删除的方法");
        String cid = req.getParameter("cid");
        ClasstService cs = (ClasstService) ServiceFactory.getService(new ClasstServiceImpl());
        int i=cs.deleteById(cid);
        if(i==1){
            resp.sendRedirect(req.getContextPath()+"/category/category_selectByPage.jsp");
        }else {
            resp.getWriter().print("删除失败");
        }
    }

    private void editById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入到edit页面");
        String cid = req.getParameter("cid");
        ClasstService cs=new ClasstServiceImpl();
        Classt classt = cs.editById(cid);
        req.setAttribute("editclasst",classt);
        req.getRequestDispatcher("/category/category_toAdd.jsp").forward(req,resp);
    }

    private void selectById(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入到根据id查单条记录");
        String lbid = req.getParameter("lbid");
        ClasstService cs=new ClasstServiceImpl();
        Boolean flag=cs.selectById(lbid);
        PrintJson.printJsonFlag(resp,flag);

    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入到save方法中");
        String lbid = req.getParameter("lbid");
        String lbmc = req.getParameter("lbmc");
        String lbms = req.getParameter("lbms");
        int  flagpd = Integer.valueOf(req.getParameter("flag"));
        if(flagpd==0){
            String lbsj= DateTimeUtil.getSysTime();
            Classt classt=new Classt();
            classt.setCid(lbid);
            classt.setCname(lbmc);
            classt.setDescribe_1(lbms);
            classt.setCcreatetime(lbsj);
            ClasstService cs= (ClasstService) ServiceFactory.getService(new ClasstServiceImpl());
            //ClasstService cs=new ClasstServiceImpl();
            Boolean flag=cs.save(classt);

            PrintJson.printJsonFlag(resp,flag);
        }else {

            Classt classt=new Classt();
            classt.setCid(lbid);
            classt.setCname(lbmc);
            classt.setDescribe_1(lbms);

            ClasstService cs= (ClasstService) ServiceFactory.getService(new ClasstServiceImpl());
            //ClasstService cs=new ClasstServiceImpl();
            Boolean flag=cs.update(classt);

            PrintJson.printJsonFlag(resp,flag);
        }

    }

    private void selectList(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入selectList方法");

        String lbid = req.getParameter("lbid");
        String lbmc = req.getParameter("lbmc");
        String ms = req.getParameter("ms");
        String pageNoStr = req.getParameter("pageNo");
        int pageNo=Integer.valueOf(pageNoStr);

        int skipCount=(pageNo-1)*3;
        ClasstService cs=new ClasstServiceImpl();
         Map<String,Object> map=new HashMap();
         map.put("lbid",lbid);
         map.put("lbmc",lbmc);
         map.put("ms",ms);
         map.put("num1",skipCount);
         map.put("num2",3);
        PageVO<Classt> vo=cs.selectList(map);
        PrintJson.printJsonObj(resp,vo);
    }
}
