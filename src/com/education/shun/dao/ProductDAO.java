/*
package com.education.shun.dao;

import com.education.shun.entity.User;
import com.education.shun.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * @program: ParkingSystem
 * @description: 数据库操作类
 * @author: qishun zhou
 * @create: 2021-04-03 13:22
 **//*


public class ProductDAO {

    public static boolean insert(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "INSERT INTO t_user(name, type, price, descs) VALUES (?, ?, ?, ?);";
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getType());
            statement.setInt(3, user.getPrice());
            statement.setString(4, user.getDescs());
            int count = statement.executeUpdate();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, statement);
        }
        return false;
    }

    public static boolean update(User user) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "UPDATE t_user SET name = ?, type = ?, price = ?, descs = ? WHERE id = ?;";
            statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getType());
            statement.setString(3, user.getPrice());
            statement.setString(4, user.getDescs());
            statement.setString(5, user.getId());
            int count = statement.executeUpdate();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, statement);
        }
        return false;
    }

    public static boolean delete(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "DELETE FROM t_user WHERE id = ?;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int count = statement.executeUpdate();
            return count > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, statement);
        }
        return false;
    }

    public static User findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT * FROM t_user WHERE id = ?;";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                return new User(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("type"), resultSet.getInt("price"), resultSet.getString("descs"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return null;
    }

    public static List<User> findAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> list = new ArrayList<>();
        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT * FROM product";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                User pro = new User(resultSet.getInt("id"),
                        resultSet.getString("name"), resultSet.getString("type"),
                        resultSet.getInt("price"), resultSet.getString("descs"));
                list.add(pro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return list;
    }

}
*/
