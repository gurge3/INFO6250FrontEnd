package entity;

import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by wuxingyao on 2017/12/5.
 */
@Entity
@Table(name = "person", schema = "assignment9", catalog = "")
public class PersonEntity {
  private int personId;
  private String firstName;
  private String lastName;
  private String email;
  private Timestamp dob;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "person_id")
  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  @Basic
  @Column(name = "first_name")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  @Basic
  @Column(name = "last_name")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Basic
  @Column(name = "email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Basic
  @Column(name = "dob")
  public Timestamp getDob() {
    return dob;
  }

  public void setDob(Timestamp dob) {
    this.dob = dob;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PersonEntity that = (PersonEntity) o;

    if (personId != that.personId) return false;
    if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null)
      return false;
    if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
    if (email != null ? !email.equals(that.email) : that.email != null) return false;
    if (dob != null ? !dob.equals(that.dob) : that.dob != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = personId;
    result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    result = 31 * result + (email != null ? email.hashCode() : 0);
    result = 31 * result + (dob != null ? dob.hashCode() : 0);
    return result;
  }
}
