package entity;

import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by wuxingyao on 2017/12/5.
 */
@Entity
@Table(name = "payment", schema = "assignment9", catalog = "")
public class PaymentEntity {
  private int paymentId;
  private String creditCardNumber;
  private String creditCardCvv;
  private Date creditCardExp;
  private int paymentAmount;
  private UserEntity user;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "payment_id")
  public int getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(int paymentId) {
    this.paymentId = paymentId;
  }

  @Basic
  @Column(name = "credit_card_number")
  public String getCreditCardNumber() {
    return creditCardNumber;
  }

  public void setCreditCardNumber(String creditCardNumber) {
    this.creditCardNumber = creditCardNumber;
  }

  @Basic
  @Column(name = "credit_card_cvv")
  public String getCreditCardCvv() {
    return creditCardCvv;
  }

  public void setCreditCardCvv(String creditCardCvv) {
    this.creditCardCvv = creditCardCvv;
  }

  @Basic
  @Column(name = "credit_card_exp")
  public Date getCreditCardExp() {
    return creditCardExp;
  }

  public void setCreditCardExp(Date creditCardExp) {
    this.creditCardExp = creditCardExp;
  }

  @Basic
  @Column(name = "payment_amount")
  public int getPaymentAmount() {
    return paymentAmount;
  }

  public void setPaymentAmount(int paymentAmount) {
    this.paymentAmount = paymentAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PaymentEntity that = (PaymentEntity) o;

    if (paymentId != that.paymentId) return false;
    if (paymentAmount != that.paymentAmount) return false;
    if (creditCardNumber != null ? !creditCardNumber.equals(that.creditCardNumber) : that
            .creditCardNumber != null)
      return false;
    if (creditCardCvv != null ? !creditCardCvv.equals(that.creditCardCvv) : that.creditCardCvv !=
            null)
      return false;
    if (creditCardExp != null ? !creditCardExp.equals(that.creditCardExp) : that.creditCardExp !=
            null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = paymentId;
    result = 31 * result + (creditCardNumber != null ? creditCardNumber.hashCode() : 0);
    result = 31 * result + (creditCardCvv != null ? creditCardCvv.hashCode() : 0);
    result = 31 * result + (creditCardExp != null ? creditCardExp.hashCode() : 0);
    result = 31 * result + paymentAmount;
    return result;
  }

  @OneToOne
  @JoinColumn(name = "user_id")
  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }
}
