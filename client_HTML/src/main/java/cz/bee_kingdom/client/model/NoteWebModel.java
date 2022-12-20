package cz.bee_kingdom.client.model;

public class NoteWebModel extends NoteDTO{
    private boolean nameError;

    public NoteWebModel() {}

    public NoteWebModel(boolean nameError, NoteDTO noteDTO) {
        super(noteDTO.getId(), noteDTO.getText(), noteDTO.getDate(), noteDTO.getTypeNote(), noteDTO.getIdColony());
        this.nameError = nameError;
    }

    public boolean isNameError() {
        return nameError;
    }

    public void setNameError(boolean nameError) {
        this.nameError = nameError;
    }
}
