package com.example.model.service.impl;

import com.example.model.dao.AttendanceDAO;
import com.example.model.dao.models.AttendanceModel;
import com.example.model.service.contracts.AttendanceService;
import com.example.model.service.mappers.AttendanceMapper;
import com.example.model.service.models.AttendanceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceDAO attendanceDAO;
    private final AttendanceMapper attendanceMapper;

    @Autowired
    public AttendanceServiceImpl(AttendanceDAO attendanceDAO) {
        this.attendanceDAO = attendanceDAO;
        attendanceMapper = new AttendanceMapper();
    }

    @Override
    public List<AttendanceDTO> getAllAttendances() {
        List<AttendanceModel> attendances = attendanceDAO.findAll();

        //lambda
        return
                attendances.stream().map(attendanceModel -> attendanceMapper.map(attendanceModel)).collect(Collectors.toList());
    }

    @Override
    public AttendanceDTO getAttendanceByID(Long idattendance) {
        return attendanceMapper.map(attendanceDAO.findById(idattendance).get());
    }

    @Override
    public AttendanceDTO saveAttendance(AttendanceDTO attendanceDTO) {
        AttendanceModel attendanceToBeSaved = attendanceMapper.map(attendanceDTO);

        attendanceDAO.save(attendanceToBeSaved);

        return attendanceDTO;
    }

    @Override
    public AttendanceDTO updateAttendance(Long idattendance, AttendanceDTO attendanceDTO) {
        AttendanceModel attendanceToBeUpdated = attendanceDAO.findById(idattendance).get();

        if(attendanceToBeUpdated != null) {
            attendanceDTO.setIdattendance(idattendance);
            attendanceDAO.save(attendanceMapper.map(attendanceDTO));

            return attendanceDTO;
        } else {
            return null;
        }

    }

    @Override
    public List<AttendanceDTO> findByIduser(Long iduser) {
        List<AttendanceModel> attendances = attendanceDAO.findByUserModelAtt_iduser(iduser);

        if(attendances != null){
            return attendances.stream().map(attendanceModel -> attendanceMapper.map(attendanceModel)).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public List<AttendanceDTO> findByIdlaboratory(Long idlaboratory) {
        List<AttendanceModel> attendances = attendanceDAO.findByLaboratoryModelAtt_idlaboratory(idlaboratory);

        if(attendances != null){
            return attendances.stream().map(attendanceModel -> attendanceMapper.map(attendanceModel)).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public AttendanceDTO markPresent(Long iduser, Long idlaboratory, int bonusPoints) {
        AttendanceDTO attendanceDTO = new AttendanceDTO();

        attendanceDTO.setIduser(iduser);
        attendanceDTO.setIdlaboratory(idlaboratory);
        attendanceDTO.setBonusPoints(bonusPoints);

        return this.saveAttendance(attendanceDTO);
    }

    @Override
    public void deleteAttendanceById(Long idattendance) {
        attendanceDAO.deleteById(idattendance);
    }
}
