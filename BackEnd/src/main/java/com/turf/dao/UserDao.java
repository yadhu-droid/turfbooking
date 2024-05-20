package com.turf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.turf.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {

	User findByUserEmail(String email);

	User findByUserId(int userId);

}
