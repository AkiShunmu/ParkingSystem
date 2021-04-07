package com.education.shun.dao;

import com.education.shun.entity.User;
import com.education.shun.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: ParkingSystem
 * @description: 用户信息数据操作
 * @author: qishun zhou
 * @create: 2021-04-03 16:05
 **/

public class UserMapper {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    //查找用户
    public User userFind(String userName) {
        /*Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;*/

        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT * FROM userinfo WHERE username = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return new User(resultSet.getString("id"), resultSet.getString("userName"),
                        resultSet.getString("userPassword"), resultSet.getString("email"),
                        resultSet.getInt("saveUser"), resultSet.getString("loginCont"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return null;
    }

    //查找所有用户
    public List<User> userFindAll() {
        /*Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;*/
        List<User> list = new ArrayList<>();

        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT * FROM userinfo";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getString("id"), resultSet.getString("userName"),
                        resultSet.getString("userPassword"), resultSet.getString("email"),
                        resultSet.getInt("saveUser"), resultSet.getString("loginCont"));
                list.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement, resultSet);
        }
        return list;
    }

    //添加用户
    public boolean userInsert(String id, String userName, String userPassword, String email, Integer saveUser ,String loginCont) {
        /*Connection connection = null;
        PreparedStatement statement = null;*/

        try {
            connection = DBUtil.getConnection();
            String sql = "INSERT INTO userinfo(id, username, userpassword, email, saveUser ,logincont) VALUES (?, ?, ?, ?, ? ,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, userName);
            statement.setString(3, userPassword);
            statement.setString(4, email);
            statement.setInt(5, saveUser);
            statement.setString(6, loginCont);
            int cont = statement.executeUpdate();
            return cont > 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement);
        }
        return false;
    }

    /**
     * 设置是否保存用户
     * @param saveUser
     * @param userName
     */
    public void setSaveUser(Integer saveUser, String userName) {
        try {
            connection = DBUtil.getConnection();
            String sql = "UPDATE userinfo SET saveuser = ? WHERE username = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1, saveUser);
            statement.setString(2, userName);
            statement.executeUpdate();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement);
        }
    }

    public User getSaveUser() {
        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT * FROM userinfo WHERE saveuser = '1'";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return new User(resultSet.getString("id"), resultSet.getString("userName"),
                        resultSet.getString("userPassword"), resultSet.getString("email"),
                        resultSet.getInt("saveUser"), resultSet.getString("loginCont"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement);
        }
        return null;
    }

    public List<User> getAllSaveUserAll() {
        List<User> list = new ArrayList<>();

        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT * FROM userinfo WHERE saveuser = '1'";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                User user = new User(resultSet.getString("id"), resultSet.getString("userName"),
                        resultSet.getString("userPassword"), resultSet.getString("email"),
                        resultSet.getInt("saveUser"), resultSet.getString("loginCont"));
                list.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeAll(connection, statement);
        }
        return list;
    }

}
