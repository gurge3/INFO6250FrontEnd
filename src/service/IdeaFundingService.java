package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import dao.IdeaDao;
import dao.IdeaFundingDao;
import entity.IdeaEntity;
import entity.IdeaFundingEntity;
import controller.ideaFunding.FundingCreation;

@Service
public class IdeaFundingService {

  @Autowired
  private IdeaFundingDao ideaFundingDao;

  @Autowired
  private IdeaDao ideaDao;

  public List<IdeaFundingEntity> findAll() {
    return ideaFundingDao.findAll();
  }

  public IdeaFundingEntity findOne(Integer ideaFundingId) {
    return ideaFundingDao.findOne(ideaFundingId);
  }

  public List<IdeaFundingEntity> findFundingsByIdeaId(Integer ideaId) {
    return ideaFundingDao.findFundingsByIdeaId(ideaId);
  }

  public boolean createFunding(FundingCreation fundingCreation) {
    IdeaFundingEntity funding = new IdeaFundingEntity();
    IdeaEntity idea = ideaDao.findOne(fundingCreation.getIdeaId());
    if (idea == null) {
      return false;
    } else {
      funding.setIdea(idea);
      funding.setIdeaFundingAvailability(fundingCreation.getIdeaFundingAvailability());
      funding.setIdeaFundingDesc(fundingCreation.getIdeaFundingDesc());
      funding.setIdeaFundingPrice(fundingCreation.getIdeaFundingPrice());
      funding.setIdeaFundingServiceAmount(fundingCreation.getIdeaFundingServiceAmount());
      ideaFundingDao.save(funding);
      return true;
    }
  }

  public boolean deleteFunding(Integer ideaFundingId) {
    ideaFundingDao.delete(ideaFundingId);
    return true;
  }

  public boolean updateFunding(FundingCreation fundingCreation, Integer ideaFundingId) {
    IdeaFundingEntity funding = ideaFundingDao.findOne(ideaFundingId);
    if (funding == null) {
      return false;
    } else {
      // Changing idea is not supported.
      funding.setIdeaFundingAvailability(fundingCreation.getIdeaFundingAvailability());
      funding.setIdeaFundingDesc(fundingCreation.getIdeaFundingDesc());
      funding.setIdeaFundingPrice(fundingCreation.getIdeaFundingPrice());
      funding.setIdeaFundingServiceAmount(fundingCreation.getIdeaFundingServiceAmount());
      ideaFundingDao.save(funding);
      return true;
    }
  }
}
