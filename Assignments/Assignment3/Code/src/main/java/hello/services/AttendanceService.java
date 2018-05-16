package hello.services;

import hello.models.Attendance;
import hello.models.AttendanceWUserAndLab;

import java.util.List;

public interface AttendanceService {

    public List<AttendanceWUserAndLab> getAllAttendances(String email, Long idlaboratory);

    public Attendance createAttendance(String email, Long idLaboratory);
}
