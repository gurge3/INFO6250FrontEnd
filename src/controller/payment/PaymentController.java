package controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import entity.PaymentEntity;
import service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PaymentController {

  @Autowired
  private PaymentService paymentService;

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public @ResponseBody
  List<PaymentEntity> getAllPayments() {
    return paymentService.findAll();
  }

  @RequestMapping(path = "/{paymentId}", method = RequestMethod.GET)
  public @ResponseBody PaymentEntity getPaymentById(@PathVariable("paymentId") Integer paymentId, HttpServletResponse response) {
    PaymentEntity result = paymentService.findOne(paymentId);
    if (result == null) {
      // Setting 422 to warn the front end.
      response.setStatus(422);
      return null;
    } else {
      return result;
    }
  }
}
