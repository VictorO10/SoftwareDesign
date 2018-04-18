package com.example.model.dao;

import com.example.model.dao.models.AttendanceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AttendanceDAO extends JpaRepository<AttendanceModel, Long>{

    public List<AttendanceModel> findByLaboratoryModelAtt_idlaboratory(Long id);

    public List<AttendanceModel> findByUserModelAtt_iduser(Long id);
}
