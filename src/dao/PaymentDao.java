package dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import entity.PaymentEntity;

@ResponseBody
public interface PaymentDao extends JpaRepository<PaymentEntity, Integer> {
}
