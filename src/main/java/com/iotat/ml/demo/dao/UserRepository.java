package com.iotat.ml.demo.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.iotat.ml.demo.entity.User;
public interface UserRepository extends JpaRepository<User, Long> {

        User findByUserName(String userName);

}
