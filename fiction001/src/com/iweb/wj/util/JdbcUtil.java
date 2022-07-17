package com.iweb.wj.util;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtil {
    static Connection conn=null;//表示数据库的连接
    static PreparedStatement ps=null;//表示用来操作sql语句的对象
    static ResultSet rs=null;//用来接收查询结果集的对象
    static ResultSetMetaData rsmd=null;//这是一个用来获取ResultSet总列信息的对象
    private static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动类
            conn= DriverManager.getConnection("jdbc:mysql://192.168.77.100:3306/mysql?characterEncoding=utf-8",
                    "root", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    /**
     * 关闭资源
     */
    private static void closeJdbc() throws SQLException {
        if(rs!=null)
            rs.close();
        if(conn!=null)
            conn.close();
        if(ps!=null)
            ps.close();
    }

    /**
     * 查询方法
     */
    public  static  synchronized <K> List<Map<String,Object>> queryBySql(String sql, K ... cs){
        List<Map<String,Object>> list=new ArrayList<>();
        try {
            conn=getConnection();
            ps=conn.prepareStatement(sql);
            //参数绑定
            for (int i = 0; i < cs.length; i++) {
                //方法一
                /*switch (cs[i].getClass().getSimpleName()){
                    case "String":ps.setString(i+1,(String) cs[i]);
                        break;
                    case "Ingeger":ps.setInt(i+1,(Integer) cs[i]);
                        break;
                    default:
                        break;
                }*/
                //方法二
                ps.setObject(i+1,cs[i]);


            }
            rs=ps.executeQuery();
            rsmd=rs.getMetaData();
            while (rs.next()){
                Map<String,Object> map=new HashMap<>();
                for (int i = 1; i <=rsmd.getColumnCount(); i++) {
                    map.put(rsmd.getColumnName(i),rs.getObject(i));
                }
                list.add(map);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                closeJdbc();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return list;
    }
    /**
     * 增删改
     */
        public synchronized static <E>int updateBySql(String sql,E ... cs){
            int i=0;
            try {
                conn=getConnection();
                ps=conn.prepareStatement(sql);
                for (int j = 0; j < cs.length; j++) {
                    ps.setObject(j+1,cs[j]);
                }
                 i= ps.executeUpdate();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    closeJdbc();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
            return i;
        }

}
