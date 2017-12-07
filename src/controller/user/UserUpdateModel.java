package controller.user;

/**
 * Created by wuxingyao on 2017/12/6.
 */
public class UserUpdateModel {
  private Integer userId;
  private String password;

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
