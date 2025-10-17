package com.dgut.springbootdemo.services;

import com.dgut.springbootdemo.bean.User;

public interface UserService {

    User getUserById(long id);

    Long addNewUser(User user);

    Long deleteUserById(long id);

    Long updateUserById(long id, String name, String email, int age);
}
