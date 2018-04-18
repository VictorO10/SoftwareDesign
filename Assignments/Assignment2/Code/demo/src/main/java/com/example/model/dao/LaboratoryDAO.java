package com.example.model.dao;

import com.example.model.dao.models.AssignmentModel;
import com.example.model.dao.models.LaboratoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface LaboratoryDAO extends JpaRepository<LaboratoryModel, Long> {

    public Set<AssignmentModel> getAssignmentsByIdlaboratory(Long idlaboratory);

    public List<LaboratoryModel> findByCurriculaContainingOrLongDescriptionContaining(String keyword1, String keyword2);

    public LaboratoryModel findByLabNb(Long LabNb);
}
