package com.example.model.dao;

import com.example.model.dao.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDAO extends JpaRepository<UserModel, Long> {

    public UserModel findByEmail(String email);
    public UserModel findByToken(String token);
}
