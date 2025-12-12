package com.batchprocessing.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batchprocessing.user.entity.User;

public interface UserRepo extends JpaRepository<User,Integer>{

}
