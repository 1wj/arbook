package com.iweb.settings.controller;

import com.iweb.settings.domain.Book;
import com.iweb.settings.domain.Charactert;
import com.iweb.settings.domain.Classt;
import com.iweb.settings.service.BookService;
import com.iweb.settings.service.ClasstService;
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

public class BookController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        System.out.println(path);
        if ("/settings/book/selectList.do".equals(path)) {
            selectList(req, resp);
        } else if ("/settings/book/save.do".equals(path)) {
            save(req, resp);
        }else if ("/settings/book/selectByid.do".equals(path)) {
            selectByid(req, resp);
        }else if ("/settings/book/editById.do".equals(path)) {
            editById(req, resp);
        }else if ("/settings/book/deleteById.do".equals(path)) {
            deleteById(req, resp);
        }else if ("/settings/book/detailById.do".equals(path)) {
            detailById(req, resp);
        }else if ("/settings/character/selectList.do".equals(path)) {
            characterSelectList(req, resp);
        }else if ("/settings/character/addByMc.do".equals(path)) {
            addByMc(req, resp);
        }else if ("/settings/character/deleteById.do".equals(path)) {
            deletechById(req, resp);

        }


    }

    private void deletechById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("进入到章节删除");
        String characterid = req.getParameter("characterid");
        String charactername = req.getParameter("charactername");
        Map<String ,Object> map=new HashMap<>();
        map.put("characterid",characterid);
        map.put("charactername",charactername);

        BookService bs= (BookService) ServiceFactory.getService(new BookServiceImpl());
        Boolean flag=bs.deletechById(map);
        if(flag==true){
           // resp.getWriter().print("删除成功");
            resp.sendRedirect(req.getContextPath()+"/fiction/chapter_selectByPage.jsp");
        }else {
            resp.getWriter().print("删除失败");
        }

    }

    private void addByMc(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入到根据名称添加章节对象");
        String chacMc = req.getParameter("chacMc");
        Charactert charactert=new Charactert();
        charactert.setCharactername(chacMc);
        charactert.setCharacterid("5");
        charactert.setBid("44");
        charactert.setCharacterpath("e://a.txt");
        BookService bs= (BookService) ServiceFactory.getService(new BookServiceImpl());
        Boolean flag=bs.addByMc(charactert);
        PrintJson.printJsonFlag(resp,flag);
    }

    private void characterSelectList(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入到章节表的分页查询方法");
        String pageNoStr = req.getParameter("pageNo");
        int pageNo=Integer.valueOf(pageNoStr);

        int skipCount=(pageNo-1)*3;

        BookService bs=new BookServiceImpl();

        Map<String,Object> map=new HashMap();
        map.put("num1",skipCount);
        map.put("num2",3);

        PageVO<Charactert> vo=bs.characterSelectList(map);
        PrintJson.printJsonObj(resp,vo);
    }



    private void detailById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入详细信息方法");
        String bid = req.getParameter("bid");
        BookService bs=new BookServiceImpl();
        Book book = bs.editById(bid);
        req.setAttribute("detailbook",book);
        req.getRequestDispatcher("/fiction/fictionDetail.jsp").forward(req,resp);

    }

    private void deleteById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        System.out.println("进入删除小说方法");
        String bid = req.getParameter("bid");
        BookService bs = (BookService) ServiceFactory.getService(new BookServiceImpl());
        int i=bs.deleteById(bid);
        if(i==1){
            resp.sendRedirect(req.getContextPath()+"/fiction/fiction_selectByPage.jsp");
        }else {
            resp.getWriter().print("删除失败");
        }
    }

    private void editById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入编辑小说方法");
        String bid = req.getParameter("bid");
        BookService bs=new BookServiceImpl();
        Book book = bs.editById(bid);
        req.setAttribute("editbook",book);
        req.getRequestDispatcher("/fiction/fiction_toAdd.jsp").forward(req,resp);

    }

    private void selectByid(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入到根据小说id查信息");
        String xsid = req.getParameter("xsid");
        BookService bs=new BookServiceImpl();
        Boolean flag=bs.selectById(xsid);
        PrintJson.printJsonFlag(resp,flag);
    }


    private void save(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入到保存小说对象方法");
        String id = req.getParameter("xsid");
        String mc = req.getParameter("xsmc");
        String zz = req.getParameter("xszz");
        String gs = req.getParameter("xsgs");
        String hy = req.getParameter("xshy");
        String sj = req.getParameter("xssj");
        int  flagpd = Integer.valueOf(req.getParameter("flag"));
        if(flagpd==0){
            String cjsj= DateTimeUtil.getSysTime();
            String cbsj= DateTimeUtil.getSysTime();
            Book book=new Book();
            book.setBid(id);
            book.setBname(mc);
            book.setAuthor(zz);
            book.setBproperty(gs);
            book.setIsvip(hy);
            book.setStatus(sj);
            book.setBcreatetime(cjsj);
            book.setPublishtime(cbsj);
            book.setPage(5000);
            BookService bs= (BookService) ServiceFactory.getService(new BookServiceImpl());
            //ClasstService cs=new ClasstServiceImpl();
            Boolean flag=bs.save(book);

            PrintJson.printJsonFlag(resp,flag);
        }else {

            Book book=new Book();
            book.setBid(id);
            book.setBname(mc);
            book.setAuthor(zz);
            book.setBproperty(gs);
            book.setIsvip(hy);
            book.setStatus(sj);

            BookService bs= (BookService) ServiceFactory.getService(new BookServiceImpl());
            //ClasstService cs=new ClasstServiceImpl();
            Boolean flag=bs.update(book);

            PrintJson.printJsonFlag(resp,flag);
        }
    }
    //查询小说所有集合方法
    private void selectList(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("进入查询小说所有集合方法");
        String xsid = req.getParameter("xsid");
        String xsmc = req.getParameter("xsmc");
        String xszz = req.getParameter("xszz");
        String pageNoStr = req.getParameter("pageNo");
        int pageNo=Integer.valueOf(pageNoStr);

        int skipCount=(pageNo-1)*3;

        BookService bs=new BookServiceImpl();

        Map<String,Object> map=new HashMap();
        map.put("xsid",xsid);
        map.put("xsmc",xsmc);
        map.put("xszz",xszz);
        map.put("num1",skipCount);
        map.put("num2",3);

        PageVO<Book> vo=bs.selectList(map);
        PrintJson.printJsonObj(resp,vo);

    }
}
