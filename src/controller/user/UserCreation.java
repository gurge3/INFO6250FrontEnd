package controller.user;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.Date;

public class UserCreation {

  private String firstname;
  private String lastname;
  private String email;
  private String username;
  private String password;
  private Integer roleId;
  private Integer personId;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Timestamp dob;

  public UserCreation() {
    // TODO Auto-generated constructor stub
  }

  public Integer getPersonId() {
    return personId;
  }

  public void setPersonId(Integer personId) {
    this.personId = personId;
  }

  public void setDob(Timestamp dob) {
    this.dob = dob;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getRoleId() {
    return roleId;
  }

  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }


  public String getFirstname() {
    return firstname;
  }


  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }


  public String getLastname() {
    return lastname;
  }


  public void setLastname(String lastname) {
    this.lastname = lastname;
  }


  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public Date setDob() {
    return this.dob;
  }

  public Timestamp getDob() {
    return dob;
  }


}
