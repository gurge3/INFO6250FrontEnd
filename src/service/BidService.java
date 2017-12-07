package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.transaction.Transactional;

import controller.bid.BidCreationWithAmountOnly;
import controller.bid.BidCreationWithPaymentInfo;
import dao.BidDao;
import dao.IdeaFundingDao;
import dao.PaymentDao;
import dao.UserDao;
import entity.BidEntity;
import entity.IdeaFundingEntity;
import entity.PaymentEntity;
import entity.UserEntity;

@Service
public class BidService {

  private static final String KEY = "Bar12345Bar12345";

  @Autowired
  private BidDao bidDao;

  @Autowired
  private IdeaFundingDao ideaFundingDao;

  @Autowired
  private UserDao userDao;

  @Autowired
  private PaymentDao paymentDao;

  @Transactional
  public List<BidEntity> findAll() {
    return bidDao.findAll();
  }

  @Transactional
  public BidEntity findOne(Integer bidId) {
    return bidDao.findOne(bidId);
  }

  @Transactional
  public boolean createBid(BidCreationWithPaymentInfo bidCreation) {
    BidEntity bid = new BidEntity();
    int ideaFundingId = bidCreation.getIdeaFundingId();
    int userId = bidCreation.getUserId();
    IdeaFundingEntity funding = ideaFundingDao.findOne(ideaFundingId);
    UserEntity user = userDao.findOne(userId);
    if (funding == null || user == null) {
      return false;
    } else {
      bid.setIdeaFunding(funding);
      bid.setUser(user);
      // Creating payment
      String creditCardNumber = bidCreation.getCreditCardNumber();
      String creditCardCvv = bidCreation.getCreditCardCvv();
      Date creditCardExp = bidCreation.getCreditCardExp();
      int paymentAmount = bidCreation.getPaymentAmount();
      // Securing information
      Key aesKey = new SecretKeySpec(KEY.getBytes(), "AES");
      try {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        // To simplify, only encrypt credit card number and cvv
        String encryptedCreditCardNumber = new String(cipher.doFinal(creditCardNumber.getBytes()));
        String encryptedCreditCardCvv = new String(cipher.doFinal(creditCardCvv.getBytes()));
        PaymentEntity payment = new PaymentEntity();
        payment.setCreditCardCvv(encryptedCreditCardCvv);
        payment.setCreditCardExp(creditCardExp);
        payment.setCreditCardNumber(encryptedCreditCardNumber);
        payment.setPaymentAmount(paymentAmount);
        payment.setUser(user);
        paymentDao.saveAndFlush(payment);
        bid.setPayment(payment);
        bidDao.saveAndFlush(bid);
        return true;
      } catch (Exception e) {
        e.printStackTrace();
        return false;
      }

    }
  }

  @Transactional
  public boolean deleteBid(Integer bidId) {
    bidDao.delete(bidId);
    return true;
  }
}
