package hello.services;

import hello.models.Laboratory;
import hello.models.LaboratoryWAssignments;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;


public interface LaboratoryService {

    List<LaboratoryWAssignments> getAllLaboratories(String keyword);

    LaboratoryWAssignments getLaboratoryById(Long idlab);

    LaboratoryWAssignments getLaboratoryByLabNb(Long labNb);


    Laboratory updateLaboratory(LaboratoryWAssignments laboratoryWAssignments);

    Laboratory createLaboratory(LaboratoryWAssignments laboratoryWAssignments);

    String deletelaboratory(Long idlaboratory);
}
