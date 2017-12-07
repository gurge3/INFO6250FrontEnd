package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.PersonEntity;

@Repository
public interface PersonDao extends JpaRepository<PersonEntity, Integer> {
	
}