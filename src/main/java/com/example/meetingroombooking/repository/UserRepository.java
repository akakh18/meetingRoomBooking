package com.example.meetingroombooking.repository;

import com.example.meetingroombooking.model.entity.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query(value = "insert into User (username, fullName, password) " +
            "values (:username, :fullName, :password)",
            nativeQuery = true)
    void insertUser(@Param("username") String username, @Param("fullName") String name,
                    @Param("password") String password);
}