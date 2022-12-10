package cz.bee_kingdom.client.model;

public class ColonyWebModel extends ColonyDTO {
    private boolean nameError;

    public ColonyWebModel() {}

    public ColonyWebModel(boolean nameError, ColonyDTO colonyDTO) {
        super(colonyDTO.getExtensionsNumber(), colonyDTO.getAvailability(), colonyDTO.getName());
        this.nameError = nameError;
    }

    public boolean isNameError() {
        return nameError;
    }

    public void setNameError(boolean nameError) {
        this.nameError = nameError;
    }
}
