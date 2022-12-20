package cz.bee_kingdom.client.model;

public class TreatmentTypeWebModel extends TreatmentTypeDTO{
    private boolean nameError;

    public TreatmentTypeWebModel() {}

    public TreatmentTypeWebModel(boolean nameError, TreatmentTypeDTO treatmentDTO) {
        super(treatmentDTO.getName());
        this.nameError = nameError;
    }

    public boolean isNameError() {
        return nameError;
    }

    public void setNameError(boolean nameError) {
        this.nameError = nameError;
    }
}
