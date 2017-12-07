package controller.category;

/**
 * Created by wuxingyao on 2017/12/6.
 */
public class CategoryUpdateModel {
  private Integer categoryId;
  private String categoryName;

  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer categoryId) {
    this.categoryId = categoryId;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }
}
