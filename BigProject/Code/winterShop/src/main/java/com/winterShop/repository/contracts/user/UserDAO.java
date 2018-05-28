package com.winterShop.repository.contracts.user;

import com.winterShop.repository.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
