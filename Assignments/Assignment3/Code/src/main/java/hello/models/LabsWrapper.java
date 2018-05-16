package hello.models;

import java.util.List;

public class LabsWrapper {

    List<LaboratoryWAssignments> labs;

    public LabsWrapper() {
    }

    public List<LaboratoryWAssignments> getLabs() {
        return labs;
    }

    public void setLabs(List<LaboratoryWAssignments> labs) {
        this.labs = labs;
    }
}
