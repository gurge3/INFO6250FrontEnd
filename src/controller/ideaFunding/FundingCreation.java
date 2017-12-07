package controller.ideaFunding;

public class FundingCreation {
  private int ideaFundingAvailability;
  private int ideaFundingServiceAmount;
  private String ideaFundingDesc;
  private int ideaFundingPrice;
  private int ideaId;

  public int getIdeaId() {
    return ideaId;
  }

  public void setIdeaId(int ideaId) {
    this.ideaId = ideaId;
  }

  public int getIdeaFundingAvailability() {
    return ideaFundingAvailability;
  }

  public void setIdeaFundingAvailability(int ideaFundingAvailability) {
    this.ideaFundingAvailability = ideaFundingAvailability;
  }

  public int getIdeaFundingServiceAmount() {
    return ideaFundingServiceAmount;
  }

  public void setIdeaFundingServiceAmount(int ideaFundingServiceAmount) {
    this.ideaFundingServiceAmount = ideaFundingServiceAmount;
  }

  public String getIdeaFundingDesc() {
    return ideaFundingDesc;
  }

  public void setIdeaFundingDesc(String ideaFundingDesc) {
    this.ideaFundingDesc = ideaFundingDesc;
  }

  public int getIdeaFundingPrice() {
    return ideaFundingPrice;
  }

  public void setIdeaFundingPrice(int ideaFundingPrice) {
    this.ideaFundingPrice = ideaFundingPrice;
  }
}
