package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "idea_funding", schema = "assignment9", catalog = "")
public class IdeaFundingEntity {
  private int ideaFundingId;
  private int ideaFundingAvailability;
  private int ideaFundingServiceAmount;
  private String ideaFundingDesc;
  private int ideaFundingPrice;
  private List<BidEntity> bids;
  private IdeaEntity idea;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "idea_funding_id")
  public int getIdeaFundingId() {
    return ideaFundingId;
  }

  public void setIdeaFundingId(int ideaFundingId) {
    this.ideaFundingId = ideaFundingId;
  }

  @Basic
  @Column(name = "idea_funding_availability")
  public int getIdeaFundingAvailability() {
    return ideaFundingAvailability;
  }

  public void setIdeaFundingAvailability(int ideaFundingAvailability) {
    this.ideaFundingAvailability = ideaFundingAvailability;
  }

  @Basic
  @Column(name = "idea_funding_service_amount")
  public int getIdeaFundingServiceAmount() {
    return ideaFundingServiceAmount;
  }

  public void setIdeaFundingServiceAmount(int ideaFundingServiceAmount) {
    this.ideaFundingServiceAmount = ideaFundingServiceAmount;
  }

  @Basic
  @Column(name = "idea_funding_desc")
  public String getIdeaFundingDesc() {
    return ideaFundingDesc;
  }

  public void setIdeaFundingDesc(String ideaFundingDesc) {
    this.ideaFundingDesc = ideaFundingDesc;
  }

  @Basic
  @Column(name = "idea_funding_price")
  public int getIdeaFundingPrice() {
    return ideaFundingPrice;
  }

  public void setIdeaFundingPrice(int ideaFundingPrice) {
    this.ideaFundingPrice = ideaFundingPrice;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    IdeaFundingEntity that = (IdeaFundingEntity) o;

    if (ideaFundingId != that.ideaFundingId) return false;
    if (ideaFundingAvailability != that.ideaFundingAvailability) return false;
    if (ideaFundingServiceAmount != that.ideaFundingServiceAmount) return false;
    if (ideaFundingPrice != that.ideaFundingPrice) return false;
    if (ideaFundingDesc != null ? !ideaFundingDesc.equals(that.ideaFundingDesc) : that
            .ideaFundingDesc != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = ideaFundingId;
    result = 31 * result + ideaFundingAvailability;
    result = 31 * result + ideaFundingServiceAmount;
    result = 31 * result + (ideaFundingDesc != null ? ideaFundingDesc.hashCode() : 0);
    result = 31 * result + ideaFundingPrice;
    return result;
  }

  @OneToMany(mappedBy = "ideaFunding")
  public List<BidEntity> getBids() {
    return bids;
  }

  public void setBids(List<BidEntity> bids) {
    this.bids = bids;
  }

  @ManyToOne
  @JoinColumn(name = "idea_id")
  @JsonIgnore
  public IdeaEntity getIdea() {
    return idea;
  }

  public void setIdea(IdeaEntity idea) {
    this.idea = idea;
  }
}
