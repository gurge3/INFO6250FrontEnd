package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.UserEntity;

@Repository
public interface UserDao extends JpaRepository<UserEntity, Integer> {
	@Query("from UserEntity user where user.person.personId =:qPersonId")
	List<UserEntity> findByPersonId(@Param("qPersonId") Integer personId);
	
	@Query("from UserEntity user where user.username =:qUsername")
	UserEntity findUserByUsername(@Param("qUsername") String username);
}
