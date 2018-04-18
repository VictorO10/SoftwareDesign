package com.example.model.dao;

import com.example.model.dao.models.AssignmentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AssignmentDAO extends JpaRepository<AssignmentModel, Long>{
    public List<AssignmentModel> findByLaboratoryModel_idlaboratory(Long id);
}
