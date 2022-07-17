package com.iweb.settings.controller;

import com.iweb.settings.domain.Messaget;
import com.iweb.settings.domain.User;
import com.iweb.settings.service.BookService;
import com.iweb.settings.service.MessageService;
import com.iweb.settings.service.UserService;
import com.iweb.settings.service.impl.BookServiceImpl;
import com.iweb.settings.service.impl.MessageServiceImpl;
import com.iweb.settings.service.impl.UserServiceImpl;
import com.iweb.settings.vo.PageVO;
import com.iweb.utils.DateTimeUtil;
import com.iweb.utils.PrintJson;
import com.iweb.utils.ServiceFactory;
import com.iweb.utils.UUIDUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if("/settings/message/selectList.do".equals(path)){
            selectList(req,resp);
        }else if("/settings/message/deleteById.do".equals(path)){
            deleteById(req,resp);
        }else if("/settings/message/userSelectList.do".equals(path)){
            userSelectList(req,resp);
        }else if("/settings/message/selectById.do".equals(path)){
            selectById(req,resp);
        }if("/settings/message/sendById.do".equals(path)){
            sendById(req,resp);
        }

    }
    private void sendById(HttpServletRequest req, HttpServletResponse resp)
    {
        System.out.println("进入到发送信息方法");
        String mtitle = req.getParameter("mtitle");
        String message_t = req.getParameter("message_t");
        String userid = req.getParameter("userid");

      //  List<Messaget> list=new ArrayList<>();
     //   for (int i = 0; i < userid.length; i++) {
            Messaget messaget=new Messaget();
            messaget.setMessage_t(message_t);
            messaget.setMid(UUIDUtil.getUUID());
            messaget.setSenderid(userid);
            messaget.setSendtime(DateTimeUtil.getSysTime());
            messaget.setMtitle(mtitle);
           // list.add(messaget);
      //  }
        MessageService ms= (MessageService) ServiceFactory.getService(new MessageServiceImpl());
        Boolean flag=ms.sendById(messaget);
        PrintJson.printJsonFlag(resp,flag);
    }

    private void selectById(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        System.out.println("进入根据id查细节方法");
        String mid = req.getParameter("mid");
        MessageService ms= (MessageService) ServiceFactory.getService(new MessageServiceImpl());
        Messaget messaget=ms.selectById(mid);
        req.setAttribute("messaget",messaget);
        req.getRequestDispatcher("/notice/notice_content.jsp").forward(req,resp);
    }

    private void userSelectList(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入消息模块中用户查询方法");
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

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("进入删除消息方法");
        String mid = req.getParameter("mid");
        MessageService ms= (MessageService) ServiceFactory.getService(new MessageServiceImpl());
        int i=ms.deleteById(mid);
        if(i==1){
            resp.sendRedirect(req.getContextPath()+"/notice/notice_selectByPage.jsp");
        }else {
            resp.getWriter().print("删除失败");
        }
    }

    private void selectList(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入到消息的分页查询方法");
        String mid = req.getParameter("mid");
        String mtitle = req.getParameter("mtitle");
        String message_t = req.getParameter("message_t");
        String startTime = req.getParameter("startTime");
        String endTime = req.getParameter("endTime");
        String pageNoStr = req.getParameter("pageNo");

        int pageNo=Integer.valueOf(pageNoStr);
        int skipCount=(pageNo-1)*3;
        MessageService ms=new MessageServiceImpl();
        Map<String,Object> map=new HashMap();

        map.put("mid",mid);
        map.put("mtitle",mtitle);
        map.put("message_t",message_t);
        map.put("startTime",startTime);
        map.put("endTime",endTime);
        map.put("num1",skipCount);
        map.put("num2",3);

        PageVO<Messaget> vo=ms.selectList(map);
        PrintJson.printJsonObj(resp,vo);
    }
}
