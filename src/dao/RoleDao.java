package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import entity.RoleEntity;

@Repository
public interface RoleDao extends JpaRepository<RoleEntity, Integer> {
	@Query("from RoleEntity role where role.roleName=:qRoleName")
	public List<RoleEntity> findByRoleName(@Param("qRoleName") String roleName);
}
