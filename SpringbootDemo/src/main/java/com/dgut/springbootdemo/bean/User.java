package com.dgut.springbootdemo.bean;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;

@Data
@Entity  //标记该类为数据库实体类，可以被持久化到数据库中
@Table(name = "user")  //指定该实体类对应的数据库表名为"user"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //主键自增
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private int age;
}
