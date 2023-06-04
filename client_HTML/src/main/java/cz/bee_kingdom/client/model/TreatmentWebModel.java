package cz.bee_kingdom.client.model;

public class TreatmentWebModel extends TreatmentDTO {
    private boolean nameError;

    public TreatmentWebModel() {}

    public TreatmentWebModel(boolean nameError, TreatmentDTO treatmentDTO) {
        super(treatmentDTO.getDateTime(), treatmentDTO.getIdColony(), treatmentDTO.getIdType(), treatmentDTO.getId());
        this.nameError = nameError;
    }

    public boolean isNameError() {
        return nameError;
    }

    public void setNameError(boolean nameError) {
        this.nameError = nameError;
    }
}
