package com.example.model.service.contracts;

import com.example.model.service.models.AssignUserDTO;

import java.util.List;

public interface AssignUserService {

    List<AssignUserDTO> getAllAssignUsers();

    AssignUserDTO getAssignUserByID(Long idassignUser);

    AssignUserDTO saveAssignUser(AssignUserDTO assignUserDTO);

    AssignUserDTO updateAssignUser(Long idassignUser, AssignUserDTO assignUserDTO);

    List<AssignUserDTO> findByIduser(Long iduser);

    List<AssignUserDTO> findByIdassignment(Long idassignment);

    AssignUserDTO submitAssignment(String email, Long idassignment, String gitRepo, String remark);

    AssignUserDTO gradeAssignmentSubmission(Long idassignmentSubmission, int grade);

    void deleteAssignUserById(Long idassignUser);
    
}
