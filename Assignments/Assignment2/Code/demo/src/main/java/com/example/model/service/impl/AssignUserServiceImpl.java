package com.example.model.service.impl;

import com.example.model.dao.AssignUserDAO;
import com.example.model.dao.AssignmentDAO;
import com.example.model.dao.UserDAO;
import com.example.model.dao.models.AssignUserModel;
import com.example.model.dao.models.AssignmentModel;
import com.example.model.dao.models.UserModel;
import com.example.model.service.contracts.AssignUserService;
import com.example.model.service.exceptions.DeadlinePassedException;
import com.example.model.service.mappers.AssignUserMapper;
import com.example.model.service.models.AssignUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssignUserServiceImpl implements AssignUserService {

    private final AssignUserDAO assignUserDAO;
    private final AssignmentDAO assignmentDAO;
    private final UserDAO userDAO;
    private final AssignUserMapper assignUserMapper;

    @Autowired
    public AssignUserServiceImpl(AssignUserDAO assignUserDAO, UserDAO userDAO, AssignmentDAO assignmentDAO) {
        this.assignUserDAO = assignUserDAO;
        this.userDAO = userDAO;
        this.assignmentDAO = assignmentDAO;
        assignUserMapper = new AssignUserMapper();
    }

    @Override
    public List<AssignUserDTO> getAllAssignUsers() {
        List<AssignUserModel> assignUsers = assignUserDAO.findAll();

        //lambda
        return
                assignUsers.stream().map(assignUserModel -> assignUserMapper.map(assignUserModel)).collect(Collectors.toList());
    }

    @Override
    public AssignUserDTO getAssignUserByID(Long idassignUser) {
        return assignUserMapper.map(assignUserDAO.findById(idassignUser).get());
    }

    @Override
    public AssignUserDTO saveAssignUser(AssignUserDTO assignUserDTO) {
        AssignUserModel assignUserToBeSaved = assignUserMapper.map(assignUserDTO);

        assignUserDAO.save(assignUserToBeSaved);

        return assignUserDTO;
    }

    @Override
    public AssignUserDTO updateAssignUser(Long idassignUser, AssignUserDTO assignUserDTO) {
        AssignUserModel assignUserToBeUpdated = assignUserDAO.findById(idassignUser).get();

        if(assignUserToBeUpdated != null) {
            assignUserDTO.setIdassignuser(idassignUser);
            assignUserDAO.save(assignUserMapper.map(assignUserDTO));

            return assignUserDTO;
        } else {
            return null;
        }

    }

    @Override
    public List<AssignUserDTO> findByIduser(Long iduser) {
        List<AssignUserModel> assignUsers = assignUserDAO.findByUserModelGrade_iduser(iduser);

        if(assignUsers != null){
            return assignUsers.stream().map(assignUserModel -> assignUserMapper.map(assignUserModel)).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public List<AssignUserDTO> findByIdassignment(Long idassignUser) {
        List<AssignUserModel> assignUsers = assignUserDAO.findByAssignmentModelGrade_idassignment(idassignUser);

        if(assignUsers != null){
            return assignUsers.stream().map(assignUserModel -> assignUserMapper.map(assignUserModel)).collect(Collectors.toList());
        } else {
            return null;
        }
    }

    @Override
    public AssignUserDTO submitAssignment(String email, Long idassingment, String gitRepo, String remark) throws DeadlinePassedException {
        AssignUserDTO assignUserDTO = new AssignUserDTO();

        UserModel userModel = userDAO.findByEmail(email);

        assignUserDTO.setGitrepo(gitRepo);
        assignUserDTO.setRemark(remark);
        assignUserDTO.setIduser(userModel.getIduser());
        assignUserDTO.setIdassignment(idassingment);



        AssignmentModel assignmentModel = assignmentDAO.findById(idassingment).get();
        if(assignmentModel.getDeadline().compareTo(new Date()) < 0) { //deadline passed
            throw new DeadlinePassedException();
        } else {

            return this.saveAssignUser(assignUserDTO);
        }
    }

    @Override
    public AssignUserDTO gradeAssignmentSubmission(Long idassignmentSubmission, int grade) {
        AssignUserDTO assignUserDTO = this.getAssignUserByID(idassignmentSubmission);

        assignUserDTO.setGrade(grade);

        return this.updateAssignUser(idassignmentSubmission, assignUserDTO);
    }

    @Override
    public void deleteAssignUserById(Long idassignUser) {
        assignUserDAO.deleteById(idassignUser);
    }
}
