package com.example.user.entity.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @ClassName: User
 * @Author: zhaojh0912
 * @Dae: 2019/12/7
 * @Vsersion: 1.0.0
 * @Description: 用户实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String id;//ID

    private String loginName; //用户名

    private String password;//密码

    private String nickName;//昵称

    private String roles;//角色

    private String identityCard; //身份证号

    private String sex; //性别

    private Date birthday; //出生年月日

    private String avatar; //头像

    private String mobile; //联系方式

    private String email;//E-Mail

    private Date registerDate;//注册日期

    private Date updateDate; //修改日期

    private Date lastDate;//最后登陆日期

    private Long onlineTime; //在线时长（分钟）

    private String interest; //兴趣

    private String status; //用户状态  状态：0，正常，1 失效
}
