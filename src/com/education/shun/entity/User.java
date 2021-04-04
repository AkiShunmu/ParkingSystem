package com.education.shun.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @program: ParkingSystem
 * @description: 用户属性
 * @author: qishun zhou
 * @create: 2021-04-02 18:56
 **/

@Data
//全参构造
@AllArgsConstructor
public class User {

    /**
     * 编号
     */
    private String id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPassword;

    /**
     * 登录次数
     */
    private String loginCont;

    /**
     * 邮箱
     */
    private String email;

}
