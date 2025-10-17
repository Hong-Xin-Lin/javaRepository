package com.dgut.springbootdemo.controller;

import com.dgut.springbootdemo.bean.User;
import com.dgut.springbootdemo.result.R;
import com.dgut.springbootdemo.services.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //查询用户
    @GetMapping("/user/{id}")
    public R<User> getUserById(@PathVariable long id){
        return R.OK(userService.getUserById(id));
        //return R.OK(); 不带数据
    }

    //添加用户
    @PostMapping("/user")
        public R<Long> addNewUser(@RequestBody User user){
        return R.OK(userService.addNewUser(user));
    }

    //删除用户
    @DeleteMapping("/user/{id}")
    public R<Long> deleteUserById(@PathVariable long id){
        userService.deleteUserById(id);
        return R.OK();
    }

    //更新用户
    @PutMapping("/user/{id}")
    public R<Long> updateUserById(@PathVariable long id,@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String email,
                                  @RequestParam(required = false) Integer age){

        return R.OK(userService.updateUserById(id,name,email,age));

    }
}
