package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.transaction.Transactional;

import dao.PaymentDao;
import entity.PaymentEntity;

@Service
public class PaymentService {

  @Autowired
  private PaymentDao paymentDao;

  @Transactional
  public List<PaymentEntity> findAll() {
    return paymentDao.findAll();
  }

  @Transactional
  public PaymentEntity findOne(Integer paymentId) {
    PaymentEntity payment = paymentDao.findOne(paymentId);
    return payment;
  }
}
