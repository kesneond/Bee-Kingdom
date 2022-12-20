package cz.bee_kingdom.client.model;

public class FeedingWebModel extends FeedingDTO{
    private boolean nameError;

    public FeedingWebModel() {}

    public FeedingWebModel(boolean nameError, FeedingDTO feedingDTO) {
        super(feedingDTO.getId(), feedingDTO.getFeedingDate(), feedingDTO.getAmount(), feedingDTO.getIdColony(), feedingDTO.getFeedingType());
        this.nameError = nameError;
    }

    public boolean isNameError() {
        return nameError;
    }

    public void setNameError(boolean nameError) {
        this.nameError = nameError;
    }
}
