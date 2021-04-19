package com.education.shun.dao;

import com.education.shun.entity.ParkFee;
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
 * @description: 费用信息数据操作
 * @author: qishun zhou
 * @create: 2021-04-19 11:07
 **/

public class ParkFeeMapper {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    /**
     * 根据车牌查找费用信息
     * @param plate
     * @return
     */
    public List<ParkFee> plateFind(String plate) {

        List<ParkFee> list = new ArrayList<>();

        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT * FROM parkingfee WHERE plate = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, plate);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ParkFee parkFee = new ParkFee(resultSet.getString("parkId"), resultSet.getString("userId"),
                            resultSet.getString("plate"), resultSet.getInt("parkTime"),
                            resultSet.getInt("fee"));
                list.add(parkFee);
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

    /**
     * 根据用户名查找费用信息
     * @param userId
     * @return
     */
    public List<ParkFee> userFeeFind(String userId) {

        List<ParkFee> list = new ArrayList<>();

        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT * FROM parkingfee WHERE userid = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, userId);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ParkFee parkFee = new ParkFee(resultSet.getString("parkId"), resultSet.getString("userId"),
                        resultSet.getString("plate"), resultSet.getInt("parkTime"),
                        resultSet.getInt("fee"));
                list.add(parkFee);
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

    /**
     * 查找所有停车信息
     * @return
     */
    public List<ParkFee> allFeeFind() {

        List<ParkFee> list = new ArrayList<>();

        try {
            connection = DBUtil.getConnection();
            String sql = "SELECT * FROM parkingfee";
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ParkFee parkFee = new ParkFee(resultSet.getString("parkId"), resultSet.getString("userId"),
                        resultSet.getString("plate"), resultSet.getInt("parkTime"),
                        resultSet.getInt("fee"));
                list.add(parkFee);
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

    /**
     * 添加费用信息
     * @param parkId
     * @param userId
     * @param plate
     * @param parkTime
     * @param fee
     * @return
     */
    public boolean feeInsert(String parkId, String userId, String plate, Integer parkTime, Integer fee) {

        try {
            connection = DBUtil.getConnection();
            String sql = "INSERT INTO parkingfee(parkid, userid, plate, parktime, fee) VALUES (?, ?, ?, ?, ?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1, parkId);
            statement.setString(2, userId);
            statement.setString(3, plate);
            statement.setInt(4, parkTime);
            statement.setInt(5, fee);
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

}
