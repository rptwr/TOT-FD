package com.example.app1singlePageApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.app1singlePageApp.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
