package dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import entity.IdeaFundingEntity;

@Repository
public interface IdeaFundingDao extends JpaRepository<IdeaFundingEntity, Integer> {
  @Query("from IdeaFundingEntity funding where funding.idea.id=:qIdeaId")
  List<IdeaFundingEntity> findFundingsByIdeaId(@Param("qIdeaId") Integer ideaId);
}
