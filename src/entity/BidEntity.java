package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "bid", schema = "assignment9", catalog = "")
public class BidEntity {
  private int bidId;
  private IdeaFundingEntity ideaFunding;
  private PaymentEntity payment;
  private UserEntity user;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "bid_id")
  public int getBidId() {
    return bidId;
  }

  public void setBidId(int bidId) {
    this.bidId = bidId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    BidEntity bidEntity = (BidEntity) o;

    if (bidId != bidEntity.bidId) return false;

    return true;
  }

  @Override
  public int hashCode() {
    return bidId;
  }

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = "idea_funding_id")
  public IdeaFundingEntity getIdeaFunding() {
    return ideaFunding;
  }

  public void setIdeaFunding(IdeaFundingEntity ideaFunding) {
    this.ideaFunding = ideaFunding;
  }

  @OneToOne
  @JoinColumn(name = "payment_id")
  public PaymentEntity getPayment() {
    return payment;
  }

  public void setPayment(PaymentEntity payment) {
    this.payment = payment;
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
