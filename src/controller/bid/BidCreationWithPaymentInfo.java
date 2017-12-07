package controller.bid;

import java.sql.Date;

public class BidCreationWithPaymentInfo {
  private int ideaFundingId;
  private int userId;
  private String creditCardNumber;
  private String creditCardCvv;
  private Date creditCardExp;
  private int paymentAmount;

  public int getIdeaFundingId() {
    return ideaFundingId;
  }

  public void setIdeaFundingId(int ideaFundingId) {
    this.ideaFundingId = ideaFundingId;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  public String getCreditCardCvv() {
    return creditCardCvv;
  }

  public void setCreditCardCvv(String creditCardCvv) {
    this.creditCardCvv = creditCardCvv;
  }

  public Date getCreditCardExp() {
    return creditCardExp;
  }

  public void setCreditCardExp(Date creditCardExp) {
    this.creditCardExp = creditCardExp;
  }

  public int getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(int paymentAmount) {
    this.paymentAmount = paymentAmount;
  }
}
