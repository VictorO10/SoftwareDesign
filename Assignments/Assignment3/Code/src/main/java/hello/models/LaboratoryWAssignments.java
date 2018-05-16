package hello.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import groovy.transform.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LaboratoryWAssignments {
    private Long idlaboratory;

    private Long labNb;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfLab;

    private String title;

    private String curricula;

    private String longDescription;

    private List<Assignment> assignments;

    public LaboratoryWAssignments() {
    };

    public LaboratoryWAssignments(Long idlaboratory, Long labNb, Date dateOfLab, String title, String curricula, String longDescription) {
        this.idlaboratory = idlaboratory;
        this.labNb = labNb;
        this.dateOfLab = dateOfLab;
        this.title = title;
        this.curricula = curricula;
        this.longDescription = longDescription;
    }

    //    public LaboratoryDTO(Long idlaboratory, Long labNb, Date dateOfLab, String title, String curricula, String longDescription, Set<AssignmentDTO> assignments) {
//        this.idlaboratory = idlaboratory;
//        this.labNb = labNb;
//        this.dateOfLab = dateOfLab;
//        this.title = title;
//        this.curricula = curricula;
//        this.longDescription = longDescription;
//        this.assignments = assignments;
//    }

    public Long getIdlaboratory() {
        return idlaboratory;
    }

    public void setIdlaboratory(Long idlaboratory) {
        this.idlaboratory = idlaboratory;
    }

    public Long getLabNb() {
        return labNb;
    }

    public void setLabNb(Long labNb) {
        this.labNb = labNb;
    }

    public Date getDateOfLab() {
        return dateOfLab;
    }

    public void setDateOfLab(Date dateOfLab) {
        this.dateOfLab = dateOfLab;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCurricula() {
        return curricula;
    }

    public void setCurricula(String curricula) {
        this.curricula = curricula;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    @Override
    public String toString() {
        return "LabModel{" +
                "idlaboratory: " + idlaboratory + ",\n" +
                "labNb: " + labNb + ",\n" +
                "dateOfLab: " + dateOfLab + ",\n" +
                "title: " + title + ",\n" +
                "curricula: " + curricula + ",\n" +
                "longDescription: " + longDescription + "\n}";
    }
}
