package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by wuxingyao on 2017/12/5.
 */
@Entity
@Table(name = "idea", schema = "assignment9", catalog = "")
public class IdeaEntity {
  private int ideaId;
  private String ideaName;
  private String ideaDesc;
  private String ideaPhotoUrl;
  private Date ideaStartDate;
  private Date ideaEndDate;
  private int ideaFundExpectation;
  private int ideaFundCurrent;
  private int ideaCompletion;
  private String ideaStatus;
  private CategoryEntity category;
  private UserEntity creator;
  private List<IdeaFundingEntity> fundings;
  private String status;
  private String operationReason;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "idea_id")
  public int getIdeaId() {
    return ideaId;
  }

  public void setIdeaId(int ideaId) {
    this.ideaId = ideaId;
  }

  @Basic
  @Column(name = "idea_name")
  public String getIdeaName() {
    return ideaName;
  }

  public void setIdeaName(String ideaName) {
    this.ideaName = ideaName;
  }

  @Basic
  @Column(name = "idea_photo_url")
  public String getIdeaPhotoUrl() {
    return ideaPhotoUrl;
  }

  public void setIdeaPhotoUrl(String ideaPhotoUrl) {
    this.ideaPhotoUrl = ideaPhotoUrl;
  }

  @Basic
  @Column(name = "idea_desc")
  public String getIdeaDesc() {
    return ideaDesc;
  }

  public void setIdeaDesc(String ideaDesc) {
    this.ideaDesc = ideaDesc;
  }

  @Basic
  @Column(name = "status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Basic
  @Column(name = "operation_reason")
  public String getOperationReason() {
    return operationReason;
  }

  public void setOperationReason(String operationReason) {
    this.operationReason = operationReason;
  }

  @Basic
  @Column(name = "idea_start_date")
  public Date getIdeaStartDate() {
    return ideaStartDate;
  }

  public void setIdeaStartDate(Date ideaStartDate) {
    this.ideaStartDate = ideaStartDate;
  }

  @Basic
  @Column(name = "idea_end_date")
  public Date getIdeaEndDate() {
    return ideaEndDate;
  }

  public void setIdeaEndDate(Date ideaEndDate) {
    this.ideaEndDate = ideaEndDate;
  }

  @Basic
  @Column(name = "idea_fund_expectation")
  public int getIdeaFundExpectation() {
    return ideaFundExpectation;
  }

  public void setIdeaFundExpectation(int ideaFundExpectation) {
    this.ideaFundExpectation = ideaFundExpectation;
  }

  @Basic
  @Column(name = "idea_fund_current")
  public int getIdeaFundCurrent() {
    return ideaFundCurrent;
  }

  public void setIdeaFundCurrent(int ideaFundCurrent) {
    this.ideaFundCurrent = ideaFundCurrent;
  }

  @Basic
  @Column(name = "idea_completion")
  public int getIdeaCompletion() {
    return ideaCompletion;
  }

  public void setIdeaCompletion(int ideaCompletion) {
    this.ideaCompletion = ideaCompletion;
  }

  @Basic
  @Column(name = "idea_status")
  public String getIdeaStatus() {
    return ideaStatus;
  }

  public void setIdeaStatus(String ideaStatus) {
    this.ideaStatus = ideaStatus;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    IdeaEntity that = (IdeaEntity) o;

    if (ideaId != that.ideaId) return false;
    if (ideaFundExpectation != that.ideaFundExpectation) return false;
    if (ideaFundCurrent != that.ideaFundCurrent) return false;
    if (ideaCompletion != that.ideaCompletion) return false;
    if (ideaName != null ? !ideaName.equals(that.ideaName) : that.ideaName != null) return false;
    if (ideaDesc != null ? !ideaDesc.equals(that.ideaDesc) : that.ideaDesc != null) return false;
    if (ideaStartDate != null ? !ideaStartDate.equals(that.ideaStartDate) : that.ideaStartDate !=
            null)
      return false;
    if (ideaEndDate != null ? !ideaEndDate.equals(that.ideaEndDate) : that.ideaEndDate != null)
      return false;
    if (ideaStatus != null ? !ideaStatus.equals(that.ideaStatus) : that.ideaStatus != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = ideaId;
    result = 31 * result + (ideaName != null ? ideaName.hashCode() : 0);
    result = 31 * result + (ideaDesc != null ? ideaDesc.hashCode() : 0);
    result = 31 * result + (ideaStartDate != null ? ideaStartDate.hashCode() : 0);
    result = 31 * result + (ideaEndDate != null ? ideaEndDate.hashCode() : 0);
    result = 31 * result + ideaFundExpectation;
    result = 31 * result + ideaFundCurrent;
    result = 31 * result + ideaCompletion;
    result = 31 * result + (ideaStatus != null ? ideaStatus.hashCode() : 0);
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "catagory_id")
  public CategoryEntity getCategory() {
    return category;
  }

  public void setCategory(CategoryEntity category) {
    this.category = category;
  }

  @OneToOne
  @JoinColumn(name = "idea_creator_id")
  public UserEntity getCreator() {
    return creator;
  }

  public void setCreator(UserEntity creator) {
    this.creator = creator;
  }

  @OneToMany(mappedBy = "idea")
  public List<IdeaFundingEntity> getFundings() {
    return fundings;
  }

  public void setFundings(List<IdeaFundingEntity> fundings) {
    this.fundings = fundings;
  }
}
