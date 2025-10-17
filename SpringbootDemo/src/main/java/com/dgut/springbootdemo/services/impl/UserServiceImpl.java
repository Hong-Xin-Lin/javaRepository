package com.dgut.springbootdemo.services.impl;

import com.dgut.springbootdemo.bean.User;
import com.dgut.springbootdemo.dao.UserRepository;
import com.dgut.springbootdemo.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(RuntimeException::new);
        //这里没有找到用户，则抛出异常
    }

    @Override
    public Long addNewUser(User user) {
        List<User> users =userRepository.findByEmail(user.getEmail());
        if(!CollectionUtils.isEmpty(users)){
            throw new RuntimeException("用户已存在");
        }
        User user1 = userRepository.save(user);
        return user1.getId();
    }

    @Override
    public Long deleteUserById(long id) {
        userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(id + "id" + "不存在"));
        userRepository.deleteById(id);
        return 1L;
    }

    @Override
    @Transactional
    public Long updateUserById(long id, String name, String email, int age) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(id + "id" + "不存在"));
        user.setName(name);
        user.setEmail(email);
        user.setAge(age);
        userRepository.save(user);
        return 1L;
    }
}
