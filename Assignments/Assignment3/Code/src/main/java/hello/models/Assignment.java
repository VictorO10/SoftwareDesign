package hello.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Assignment {

    private Long idassignment;

    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deadline;

    private String longDescription;

    private Long idlaboratory;



    public Assignment(){
    }

    public Long getIdassignment() {
        return idassignment;
    }

    public void setIdassignment(Long idassignment) {
        this.idassignment = idassignment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public Long getIdlaboratory() {
        return idlaboratory;
    }

    public void setIdlaboratory(Long idlaboratory) {
        this.idlaboratory = idlaboratory;
    }

//    public String getDeadlineString() {
//        return deadlineString;
//    }
//
//    public void setDeadlineString(String deadlineString) {
//        this.deadlineString = deadlineString;
//    }

    //    public LaboratoryDTO getLaboratoryDTO() {
//        return laboratoryDTO;
//    }
//
//    public void setLaboratoryDTO(LaboratoryDTO laboratoryDTO) {
//        this.laboratoryDTO = laboratoryDTO;
//    }


    @Override
    public String toString() {
        return "[[[[]]]]]]\nidassignment: " + idassignment +
                "!!!\nname: " + name +
                "!!!\nidlaboratory: " + idlaboratory +
                "!!!\nlongDescription: " + longDescription +
                "!!!\ndeadline: " + deadline;
    }
}
