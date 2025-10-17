// 认证控制器
package com.dgut.springbootdemo.controller;

import com.dgut.springbootdemo.bean.AuthResponse;
import com.dgut.springbootdemo.bean.LoginRequest;
import com.dgut.springbootdemo.result.R;
import com.dgut.springbootdemo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public R<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        // 简化处理，实际项目中应该验证用户名和密码
        // 这里假设用户名为"admin"，密码为"password"就可以登录
        if ("admin".equals(loginRequest.getUsername()) &&
                "password".equals(loginRequest.getPassword())) {

            String token = jwtUtil.generateToken(loginRequest.getUsername());
            return R.OK(new AuthResponse(token));
        } else {
            return R.FAIL();
        }
    }
}
