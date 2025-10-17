//登录请求实体
package com.dgut.springbootdemo.bean;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}
