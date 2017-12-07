package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.IdeaEntity;

@Repository
public interface IdeaDao extends JpaRepository<IdeaEntity, Integer> {

}
