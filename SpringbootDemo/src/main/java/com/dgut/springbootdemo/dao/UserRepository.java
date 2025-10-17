package com.dgut.springbootdemo.dao;

import com.dgut.springbootdemo.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    // 根据email查询,不用写sql语句，JPA会自动生成SQL语句
    List<User> findByEmail(String email);
}
