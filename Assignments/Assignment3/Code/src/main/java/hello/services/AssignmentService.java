package hello.services;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import hello.models.Assignment;

import java.util.List;

public interface AssignmentService {

    List<Assignment> getAllAssignments(Long labId);

    Assignment getAssignmentById(Long assignmentId);

    Assignment updateAssignment(Long assignmentId, Assignment assignment);

    Assignment createAssignment(Assignment assignment);

    String deleteAssignment(Long idassignment);

    Assignment findById(Long assignmentId);
}
