package hello.services;

import hello.models.AssignmentSubmission;
import hello.models.AssignmentSubmissionWUserAndLab;

import java.util.List;

public interface AssignmentSubmissionService {

    List<AssignmentSubmissionWUserAndLab> getAssignmentSubbmisions(Long iduser, Long idassignment);

    void gradeAssignment(Long idSubmission, int grade);

    AssignmentSubmission submitAssignment(AssignmentSubmission assignmentSubmission);

}
