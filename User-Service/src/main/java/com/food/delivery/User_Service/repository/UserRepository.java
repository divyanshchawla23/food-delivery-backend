package com.food.delivery.User_Service.repository;

import com.food.delivery.User_Service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
    User findByPhoneNumber(String phoneNumber);

}
