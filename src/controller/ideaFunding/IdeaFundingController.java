package controller.ideaFunding;

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

import entity.IdeaFundingEntity;
import service.IdeaFundingService;

@RestController
@RequestMapping("/ideaFunding")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class IdeaFundingController {

  @Autowired
  private IdeaFundingService ideaFundingService;


  @RequestMapping(path = "/", method = RequestMethod.GET)
  public @ResponseBody
  List<IdeaFundingEntity> getAllFundings() {
    return ideaFundingService.findAll();
  }

  @RequestMapping(path = "/{ideaFundingId}", method = RequestMethod.GET)
  public @ResponseBody IdeaFundingEntity getIdeaById(@PathVariable("ideaFundingId") Integer ideaFundingId, HttpServletResponse response) {
    IdeaFundingEntity result = ideaFundingService.findOne(ideaFundingId);
    if (result == null) {
      // Setting 422 to warn the front end.
      response.setStatus(422);
      return null;
    } else {
      return result;
    }
  }

  @RequestMapping(path="/idea/{ideaId}", method = RequestMethod.GET)
  public @ResponseBody List<IdeaFundingEntity> IdeaFundingsByIdeaId(@PathVariable("ideaId") Integer ideaId, HttpServletResponse response) {
    List<IdeaFundingEntity> fundings = null;
    if ((fundings = ideaFundingService.findFundingsByIdeaId(ideaId)) != null) {
      return fundings;
    } else {
      response.setStatus(422);
      return null;
    }
  }

  @RequestMapping(path = "/", method = RequestMethod.POST)
  public ResponseEntity<?> createNewFunding(@Valid @RequestBody FundingCreation fundingCreation) {
    ResponseEntity<String> response = new ResponseEntity<String>("Funding created failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (ideaFundingService.createFunding(fundingCreation)) {
      response = new ResponseEntity<String>("Funding created successfully", HttpStatus.OK);
    }
    return response;
  }

  @RequestMapping(path = "/{ideaFundingId}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deleteIdeaFunding(@PathVariable("ideaFundingId") Integer ideaFundingId, HttpServletResponse response) {
    ResponseEntity<String> resp = new ResponseEntity<String>("Funding deleted failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (ideaFundingService.deleteFunding(ideaFundingId)) {
      resp = new ResponseEntity<String>("Funding deleted successfully", HttpStatus.OK);
    }
    return resp;
  }

  @RequestMapping(path = "/{ideaFundingId}", method = RequestMethod.PUT)
  public ResponseEntity<?> updateIdeaFunding(@Valid @RequestBody FundingCreation fundingCreation,
                                          @PathVariable("ideaFundingId") Integer ideaFundingId) {
    ResponseEntity<String> resp = new ResponseEntity<String>("Funding updated failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (ideaFundingService.updateFunding(fundingCreation, ideaFundingId)) {
      resp = new ResponseEntity<String>("Funding updated successfully", HttpStatus.OK);
    }
    return resp;
  }



}
