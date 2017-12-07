package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

import controller.category.CategoryCreation;
import controller.category.CategoryUpdateModel;
import dao.CategoryDao;
import dao.UserDao;
import entity.CategoryEntity;
import entity.UserEntity;

@Service
public class CategoryService {

  @Autowired
  private CategoryDao categoryDao;

  @Autowired
  private UserDao userDao;

  @Transactional
  public List<CategoryEntity> findAll() {
    return categoryDao.findAll();
  }

  @Transactional
  public CategoryEntity findOne(Integer categoryId) {
    return categoryDao.findOne(categoryId);
  }

  @Transactional
  /**
   * TODO: Check duplicate
   */
  public boolean createCategory(CategoryCreation categoryCreation) {
    CategoryEntity category = new CategoryEntity();
    category.setCategoryName(categoryCreation.getCategoryName());
    categoryDao.save(category);
    return true;
  }

  @Transactional
  public boolean deleteCategory(Integer categoryId) {
    categoryDao.delete(categoryId);
    return true;
  }

  @Transactional
  public boolean updateCategory(CategoryUpdateModel categoryUpdateModel) {
    CategoryEntity category = categoryDao.findOne(categoryUpdateModel.getCategoryId());
    if (category == null) {
      return false;
    } else {
      category.setCategoryName(categoryUpdateModel.getCategoryName());
      categoryDao.save(category);
      return true;
    }
  }

  @Transactional
  public boolean setStartup(Integer userId, Integer categoryId) {
    CategoryEntity category = categoryDao.findOne(categoryId);
    if (category == null) {
      return false;
    } else {
      UserEntity user = userDao.findOne(userId);
      if (user == null) {
        return false;
      } else {
        category.setStartup(user);
        categoryDao.save(category);
        return true;
      }
    }
  }
}
