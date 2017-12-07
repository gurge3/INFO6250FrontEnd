package controller.bid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import controller.category.CategoryCreation;
import entity.BidEntity;
import entity.CategoryEntity;
import service.BidService;

@RestController
@RequestMapping("/bid")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class BidController {

  @Autowired
  private BidService bidService;


  @RequestMapping(path = "/", method = RequestMethod.GET)
  public @ResponseBody
  List<BidEntity> getAllBids() {
    return bidService.findAll();
  }

  @RequestMapping(path = "/{bidId}", method = RequestMethod.GET)
  public @ResponseBody BidEntity getBidById(@PathVariable("bidId") Integer bidId, HttpServletResponse response) {
    BidEntity result = bidService.findOne(bidId);
    if (result == null) {
      // Setting 422 to warn the front end.
      response.setStatus(422);
      return null;
    } else {
      return result;
    }
  }

  @RequestMapping(path = "/", method = RequestMethod.POST)
  public ResponseEntity<?> createNewBid(@Valid @RequestBody BidCreationWithPaymentInfo bidCreation) {
    ResponseEntity<String> response = new ResponseEntity<String>("Bid creation failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (bidService.createBid(bidCreation)) {
      response = new ResponseEntity<String>("Bid created successfully", HttpStatus.OK);
    }
    return response;
  }

  @RequestMapping(path = "/{bidId}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deleteBid(@PathVariable("bidId") Integer bidId, HttpServletResponse response) {
    ResponseEntity<String> resp = new ResponseEntity<String>("Bid deleted failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (bidService.deleteBid(bidId)) {
      resp = new ResponseEntity<String>("Bid deleted successfully", HttpStatus.OK);
    }
    return resp;
  }
}
