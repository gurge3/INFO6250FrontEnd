package controller.idea;


import java.sql.Date;

public class IdeaCreation {
  private String ideaName;
  private String ideaDesc;
  private String ideaPhotoUrl;
  private Date ideaStartDate;
  private Date ideaEndDate;
  private int ideaFundExpectation;
  private int ideaFundCurrent;
  private int ideaCompletion;
  private String ideaStatus;
  private Integer categoryId;
  private Integer userId;

  public String getIdeaName() {
    return ideaName;
  }

  public void setIdeaName(String ideaName) {
    this.ideaName = ideaName;
  }

  public String getIdeaDesc() {
    return ideaDesc;
  }

  public void setIdeaDesc(String ideaDesc) {
    this.ideaDesc = ideaDesc;
  }

  public String getIdeaPhotoUrl() {
    return ideaPhotoUrl;
  }

  public void setIdeaPhotoUrl(String ideaPhotoUrl) {
    this.ideaPhotoUrl = ideaPhotoUrl;
  }

  public Date getIdeaStartDate() {
    return ideaStartDate;
  }

  public void setIdeaStartDate(Date ideaStartDate) {
    this.ideaStartDate = ideaStartDate;
  }

  public Date getIdeaEndDate() {
    return ideaEndDate;
  }

  public void setIdeaEndDate(Date ideaEndDate) {
    this.ideaEndDate = ideaEndDate;
  }

  public int getIdeaFundExpectation() {
    return ideaFundExpectation;
  }

  public void setIdeaFundExpectation(int ideaFundExpectation) {
    this.ideaFundExpectation = ideaFundExpectation;
  }

  public int getIdeaFundCurrent() {
    return ideaFundCurrent;
  }

  public void setIdeaFundCurrent(int ideaFundCurrent) {
    this.ideaFundCurrent = ideaFundCurrent;
  }

  public int getIdeaCompletion() {
    return ideaCompletion;
  }

  public void setIdeaCompletion(int ideaCompletion) {
    this.ideaCompletion = ideaCompletion;
  }

  public String getIdeaStatus() {
    return ideaStatus;
  }

  public void setIdeaStatus(String ideaStatus) {
    this.ideaStatus = ideaStatus;
  }

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }
}
