package controller.idea;


public class IdeaDisableModel {
  private Integer ideaId;
  private String disableReason;

  public String getDisableReason() {
    return disableReason;
  }

  public void setDisableReason(String disableReason) {
    this.disableReason = disableReason;
  }

  public Integer getIdeaId() {
    return ideaId;
  }

  public void setIdeaId(Integer ideaId) {
    this.ideaId = ideaId;
  }
}
