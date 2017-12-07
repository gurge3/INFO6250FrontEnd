package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.CategoryEntity;

@Repository
public interface CategoryDao extends JpaRepository<CategoryEntity, Integer> {
}
