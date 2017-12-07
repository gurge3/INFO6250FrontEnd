package controller.person;

import java.sql.Timestamp;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PersonModel {
	
	private Integer personId;
	private String firstName;
	private String lastName;
	private String email;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Timestamp dob;

	public Integer getPersonId() {
		return personId;
	}
	public void setPersonId(Integer personId) {
		this.personId = personId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Timestamp getDob() {
		return dob;
	}
	public void setDob(Timestamp dob) {
		this.dob = dob;
	}
}
