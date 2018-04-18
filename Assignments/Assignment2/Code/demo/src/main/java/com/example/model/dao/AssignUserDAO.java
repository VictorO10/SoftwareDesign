package com.example.model.dao;

import com.example.model.dao.models.AssignUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AssignUserDAO extends JpaRepository<AssignUserModel, Long> {

    public List<AssignUserModel> findByAssignmentModelGrade_idassignment(Long id);

    public List<AssignUserModel> findByUserModelGrade_iduser(Long id);
}
