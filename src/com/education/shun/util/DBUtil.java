package com.education.shun.util;

import java.sql.*;

/**
 * @program: ParkingSystem
 * @description: 数据库连接
 * @author: qishun zhou
 * @create: 2021-04-02 18:48
 **/

public class DBUtil {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // 加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获得连接, 参数分别为：url，用户名，密码
        return DriverManager
                .getConnection("jdbc:mysql://localhost:3306/shunsql?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC",
                        "root", "root");
    }

    // 先打开，后关闭
    public static void closeAll(Connection connection, PreparedStatement statement) {
        try {
            if(statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                if(connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // 先打开，后关闭
    public static void closeAll(Connection connection, PreparedStatement statement, ResultSet resultSet) {
        try {
            if(resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection, statement);
        }
    }

    public static void  main(String[] args){
        //数据库地址
        String url = "jdbc:mysql://localhost:3306/shunsql?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=UTC";
        //用户名密码
        String user = "root";
        String password = "root";
        Connection conn = null;
        try{
            conn=DriverManager.getConnection(url, user, password);
            String sql="select * from t_user;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("nickname"));
            }
            rs.close();
            ps.close();
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            if(conn!=null){
                try {
                    conn.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
