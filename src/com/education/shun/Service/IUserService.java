package com.education.shun.Service;

import com.education.shun.entity.User;

import java.util.List;


/**
 * @program: ParkingSystem
 * @description: 用户信息业务接口
 * @author: qishun zhou
 * @create: 2021-04-03 16:27
 **/


public interface IUserService {

    User userFind(String userName);

    List<User> userFindAll();

    boolean userInsert(String id, String userName, String userPassword, String email, Integer saveUser ,String loginCont);

    void setSaveUser(Integer saveUser, String userName);

    List getSaveUser();

    List<User> getAllSaveUser();

//    boolean userDelete();

}
