package com.gd.dao;

import com.gd.daomain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>{
    public List<User> findAll();

}
