package entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by wuxingyao on 2017/12/5.
 */
@Entity
@Table(name = "category", schema = "assignment9", catalog = "")
public class CategoryEntity {
  private int categoryId;
  private String categoryName;
  private List<IdeaEntity> ideas;
  private UserEntity startup;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "category_id")
  public int getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(int categoryId) {
    this.categoryId = categoryId;
  }

  @Basic
  @Column(name = "category_name")
  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CategoryEntity that = (CategoryEntity) o;

    if (categoryId != that.categoryId) return false;
    if (categoryName != null ? !categoryName.equals(that.categoryName) : that.categoryName != null)
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = categoryId;
    result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
    return result;
  }

  @OneToMany(mappedBy = "category")
  @JsonIgnore
  public List<IdeaEntity> getIdeas() {
    return ideas;
  }

  public void setIdeas(List<IdeaEntity> ideas) {
    this.ideas = ideas;
  }

  @OneToOne
  @JoinColumn(name = "startup_id")
  public UserEntity getStartup() {
    return startup;
  }

  public void setStartup(UserEntity startup) {
    this.startup = startup;
  }
}
