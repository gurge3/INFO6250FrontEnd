package controller.user;

public class UserDisableModel {
  private String disableReason;
  private Integer userId;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getDisableReason() {
    return disableReason;
  }

  public void setDisableReason(String disableReason) {
    this.disableReason = disableReason;
  }
}
