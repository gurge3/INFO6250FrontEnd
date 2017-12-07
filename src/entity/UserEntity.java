package entity;

import java.sql.Timestamp;

import javax.persistence.Basic;
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
@Table(name = "user", schema = "assignment9", catalog = "")
public class UserEntity {
  private int userId;
  private String username;
  private String password;
  private Timestamp createdOn;
  private PersonEntity person;
  private RoleEntity role;
  private String status;
  private String operationReason;

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  @Basic
  @Column(name = "username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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
  @Column(name = "password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Basic
  @Column(name = "created_on")
  public Timestamp getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Timestamp createdOn) {
    this.createdOn = createdOn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserEntity that = (UserEntity) o;

    if (userId != that.userId) return false;
    if (username != null ? !username.equals(that.username) : that.username != null) return false;
    if (password != null ? !password.equals(that.password) : that.password != null) return false;
    if (createdOn != null ? !createdOn.equals(that.createdOn) : that.createdOn != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = userId;
    result = 31 * result + (username != null ? username.hashCode() : 0);
    result = 31 * result + (password != null ? password.hashCode() : 0);
    result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
    return result;
  }

  @ManyToOne
  @JoinColumn(name = "person_id")
  public PersonEntity getPerson() {
    return person;
  }

  public void setPerson(PersonEntity person) {
    this.person = person;
  }

  @ManyToOne
  @JoinColumn(name = "role_id")
  public RoleEntity getRole() {
    return role;
  }

  public void setRole(RoleEntity role) {
    this.role = role;
  }
}
