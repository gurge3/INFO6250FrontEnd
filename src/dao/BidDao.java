package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entity.BidEntity;

@Repository
public interface BidDao extends JpaRepository<BidEntity, Integer> {
}
