package com.example.model.service.mappers;

import com.example.model.dao.models.AttendanceModel;
import com.example.model.dao.models.LaboratoryModel;
import com.example.model.dao.models.UserModel;
import com.example.model.service.models.AttendanceDTO;

public class AttendanceMapper {

    public AttendanceDTO map(AttendanceModel attendanceModel) {

        AttendanceDTO attendanceDTO = new AttendanceDTO();

        attendanceDTO.setIdattendance(attendanceModel.getIdattendance());
        attendanceDTO.setBonusPoints(attendanceModel.getBonusPoints());
        attendanceDTO.setIduser(attendanceModel.getUserModelAtt().getIduser());
        attendanceDTO.setIdlaboratory(attendanceModel.getLaboratoryModelAtt().getIdlaboratory());

        return attendanceDTO;
    }

    public AttendanceModel map(AttendanceDTO attendanceDTO) {

        AttendanceModel attendanceModel = new AttendanceModel();

        attendanceModel.setIdattendance(attendanceDTO.getIdattendance());
        attendanceModel.setBonusPoints(attendanceDTO.getBonusPoints());

        UserModel userModel = new UserModel();
        userModel.setIduser(attendanceDTO.getIduser());

        LaboratoryModel laboratoryModel = new LaboratoryModel();
        laboratoryModel.setIdlaboratory(attendanceDTO.getIdlaboratory());

        attendanceModel.setUserModelAtt(userModel);
        attendanceModel.setLaboratoryModelAtt(laboratoryModel);

        return attendanceModel;
    }
}
