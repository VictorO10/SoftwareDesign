package com.example.model.service.contracts;

import com.example.model.service.models.AttendanceDTO;

import java.util.List;

public interface AttendanceService {

    List<AttendanceDTO> getAllAttendances();

    AttendanceDTO getAttendanceByID(Long idattendance);

    AttendanceDTO saveAttendance(AttendanceDTO attendanceDTO);

    AttendanceDTO updateAttendance(Long idattendance, AttendanceDTO attendanceDTO);

    List<AttendanceDTO> findByIduser(Long iduser);

    List<AttendanceDTO> findByIdlaboratory(Long idlaboratory);

    AttendanceDTO markPresent(Long iduser, Long idlaboratory, int bonusPoints);

    void deleteAttendanceById(Long idattendance);

}
