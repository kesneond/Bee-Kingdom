package cz.bee_kingdom.client.model;

public class FeedingTypeWebModel extends FeedingTypeDTO{
    private boolean nameError;

    public FeedingTypeWebModel() {}

    public FeedingTypeWebModel(boolean nameError, FeedingTypeDTO feedingTypeDTO) {
        super(feedingTypeDTO.getName());
        this.nameError = nameError;
    }

    public boolean isNameError() {
        return nameError;
    }

    public void setNameError(boolean nameError) {
        this.nameError = nameError;
    }
}
