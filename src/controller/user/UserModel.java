package controller.user;

import controller.person.PersonModel;
import controller.role.RoleModel;

public class UserModel {
	
	private Integer userId;
	private RoleModel role;
	private String username;
	private PersonModel person;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public RoleModel getRole() {
		return role;
	}
	public void setRole(RoleModel role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPerson(PersonModel person) {
		this.person = person;
	}
	public PersonModel getPerson() {
		return person;
	}
	
	
}
