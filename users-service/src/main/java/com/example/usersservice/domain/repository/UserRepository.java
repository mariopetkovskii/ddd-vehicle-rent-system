package com.example.usersservice.domain.repository;

import com.example.usersservice.domain.models.User;
import com.example.usersservice.domain.models.UserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, UserId> {
    @Query("select u from User u where u.email=:email")
    User findByEmail(String email);
    @Query("select u from User u where u.id=:id")
    User findById(String id);
}
