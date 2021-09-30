package com.example.demo.service;


import com.example.demo.dao.RoleRepo;
import com.example.demo.dao.UserRepo;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import com.example.demo.entity.QUser;

import java.util.Arrays;
import java.util.List;


@Service
@Transactional
public class UserService {

    @Autowired
    private EntityManager em;

    JPAQueryFactory queryFactory = new JPAQueryFactory(em);

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;

    public User getUserById(int id){
        return userRepo.findById(id).get();
    }

    public void save(){
        roleRepo.save(new Role(2,"ADMIN"));
       // userRepo.save(new User(1,"Sagar","asdsadds"));
    }

    @Transactional
    public void saveQVersion(){
        User user=new User();
        user.setName("Nikhil");
        user.setPassword("admn2134");
        em.persist(user);
    }

    public List<User> findAll(){
        final JPAQuery<User> query = new JPAQuery<>(em);
        QUser user= QUser.user;
      return  query.from(user).where(user.name.eq("Sagar")).fetch();
    }
}
