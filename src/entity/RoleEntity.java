package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Created by wuxingyao on 2017/12/5.
 */
@Entity
@Table(name = "role", schema = "assignment9", catalog = "")
public class RoleEntity {
  private int roleId;
  private String roleName;
  private String roleDesc;
  private List<UserEntity> users;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "role_id")
  public int getRoleId() {
    return roleId;
  }

  public void setRoleId(int roleId) {
    this.roleId = roleId;
  }

  @Basic
  @Column(name = "role_name")
  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  @Basic
  @Column(name = "role_desc")
  public String getRoleDesc() {
    return roleDesc;
  }

  public void setRoleDesc(String roleDesc) {
    this.roleDesc = roleDesc;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    RoleEntity that = (RoleEntity) o;

    if (roleId != that.roleId) return false;
    if (roleName != null ? !roleName.equals(that.roleName) : that.roleName != null) return false;
    if (roleDesc != null ? !roleDesc.equals(that.roleDesc) : that.roleDesc != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = roleId;
    result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
    result = 31 * result + (roleDesc != null ? roleDesc.hashCode() : 0);
    return result;
  }

  @OneToMany(mappedBy = "role")
  @JsonIgnore
  public List<UserEntity> getUsers() {
    return users;
  }

  public void setUsers(List<UserEntity> users) {
    this.users = users;
  }
}
