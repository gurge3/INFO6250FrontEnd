package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

import controller.idea.IdeaAdminUpdateModel;
import controller.idea.IdeaCreation;
import controller.idea.IdeaDisableModel;
import controller.idea.IdeaEnableModel;
import dao.CategoryDao;
import dao.IdeaDao;
import dao.UserDao;
import entity.CategoryEntity;
import entity.IdeaEntity;
import entity.UserEntity;

@Service
public class IdeaService {

  @Autowired
  private IdeaDao ideaDao;

  @Autowired
  private CategoryDao categoryDao;

  @Autowired
  private UserDao userDao;

  @Transactional
  public List<IdeaEntity> findAll() {
    return ideaDao.findAll();
  }

  @Transactional
  public IdeaEntity findOne(Integer ideaId) {
    IdeaEntity result = null;
    result = ideaDao.findOne(ideaId);
    return result;
  }

  @Transactional
  public boolean createIdea(IdeaCreation ideaCreation) {
    IdeaEntity idea = new IdeaEntity();
    Integer categoryId = ideaCreation.getCategoryId();
    Integer userId = ideaCreation.getUserId();
    CategoryEntity category = categoryDao.findOne(categoryId);
    UserEntity userEntity = userDao.findOne(userId);
    if (category == null || userEntity == null) {
      return false;
    } else {
      idea.setCategory(category);
      idea.setCreator(userEntity);
      idea.setIdeaCompletion(ideaCreation.getIdeaCompletion());
      idea.setIdeaDesc(ideaCreation.getIdeaDesc());
      idea.setIdeaEndDate(ideaCreation.getIdeaEndDate());
      idea.setIdeaStartDate(ideaCreation.getIdeaStartDate());
      idea.setIdeaFundCurrent(ideaCreation.getIdeaFundCurrent());
      idea.setIdeaName(ideaCreation.getIdeaName());
      idea.setIdeaFundExpectation(ideaCreation.getIdeaFundExpectation());
      idea.setIdeaPhotoUrl(ideaCreation.getIdeaPhotoUrl());
      idea.setIdeaStatus(ideaCreation.getIdeaStatus());
      ideaDao.saveAndFlush(idea);
      return true;
    }
  }

  public boolean deleteIdea(Integer ideaId) {
    ideaDao.delete(ideaId);
    return true;
  }

  public boolean updateIdea(IdeaAdminUpdateModel ideaAdminUpdateModel) {
    IdeaEntity idea = ideaDao.findOne(ideaAdminUpdateModel.getIdeaId());
    if (idea == null) {
      return false;
    } else {
      idea.setIdeaName(ideaAdminUpdateModel.getIdeaName());
      ideaDao.save(idea);
      return true;
    }
  }

  public boolean disableIdea(IdeaDisableModel ideaDisableModel) {
    IdeaEntity idea = ideaDao.findOne(ideaDisableModel.getIdeaId());
    if (idea == null) {
      return false;
    } else {
      idea.setStatus("disabled");
      idea.setOperationReason(ideaDisableModel.getDisableReason());
      ideaDao.saveAndFlush(idea);
      return true;
    }
  }

  public boolean enable(IdeaEnableModel ideaEnableModel) {
    IdeaEntity idea = ideaDao.findOne(ideaEnableModel.getIdeaId());
    if (idea == null) {
      return false;
    } else {
      idea.setStatus(null);
      idea.setOperationReason(null);
      ideaDao.saveAndFlush(idea);
      return true;
    }

  }
}
