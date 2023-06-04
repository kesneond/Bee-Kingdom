package cz.bee_kingdom.client.model;

public class NoteTypeWebModel extends NoteTypeDTO{
    private boolean nameError;

    public NoteTypeWebModel() {}

    public NoteTypeWebModel(boolean nameError, NoteTypeDTO noteTypeDTO) {
        super(noteTypeDTO.getName());
        this.nameError = nameError;
    }

    public boolean isNameError() {
        return nameError;
    }

    public void setNameError(boolean nameError) {
        this.nameError = nameError;
    }
}
