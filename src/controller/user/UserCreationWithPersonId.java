package controller.user;

public class UserCreationWithPersonId {
	private Integer roleId;
	private String username;
	private String password;
	private Integer personId;

	public Integer getRoleId() {
		return roleId;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Integer getPersonId() {
		return personId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

}
