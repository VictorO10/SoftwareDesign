package com.example.model.service.mappers;

import com.example.model.dao.models.AssignUserModel;
import com.example.model.dao.models.AssignmentModel;
import com.example.model.dao.models.UserModel;
import com.example.model.service.models.AssignUserDTO;

public class AssignUserMapper {

    public AssignUserDTO map(AssignUserModel assignUserModel) {

        AssignUserDTO assignUserDTO = new AssignUserDTO();

        assignUserDTO.setIdassignuser(assignUserModel.getIdassignuser());
        assignUserDTO.setGrade(assignUserModel.getGrade());
        assignUserDTO.setGitrepo(assignUserModel.getGitrepo());
        assignUserDTO.setRemark(assignUserModel.getRemark());
        assignUserDTO.setIduser(assignUserModel.getUserModelGrade().getIduser());
        assignUserDTO.setIdassignment(assignUserModel.getAssignmentModelGrade().getIdassignment());

        return assignUserDTO;
    }

    public AssignUserModel map(AssignUserDTO assignUserDTO) {

        AssignUserModel assignUserModel = new AssignUserModel();

        assignUserModel.setIdassignuser(assignUserDTO.getIdassignuser());
        assignUserModel.setGrade(assignUserDTO.getGrade());
        assignUserModel.setGitrepo(assignUserDTO.getGitrepo());
        assignUserModel.setRemark(assignUserDTO.getRemark());

        UserModel userModel = new UserModel();
        userModel.setIduser(assignUserDTO.getIduser());

        AssignmentModel assignmentModel = new AssignmentModel();
        assignmentModel.setIdassignment(assignUserDTO.getIdassignment());

        assignUserModel.setUserModelGrade(userModel);
        assignUserModel.setAssignmentModelGrade(assignmentModel);

        return assignUserModel;
    }
    
}
