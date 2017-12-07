package controller.idea;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import entity.IdeaEntity;
import service.IdeaService;

@RestController
@RequestMapping("/idea")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class IdeaController {
  @Autowired
  private IdeaService ideaService;

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public @ResponseBody List<IdeaEntity> getAllIdeas() {
    return ideaService.findAll();
  }

  @RequestMapping(path = "/{ideaId}", method = RequestMethod.GET)
  public @ResponseBody IdeaEntity getIdeaById(@PathVariable("ideaId") Integer ideaId, HttpServletResponse response) {
    IdeaEntity result = ideaService.findOne(ideaId);
    if (result == null) {
      // Setting 422 to warn the front end.
      response.setStatus(422);
      return null;
    } else {
      return result;
    }
  }
  @RequestMapping(path = "/", method = RequestMethod.POST)
  public ResponseEntity<?> createNewIdea(@Valid @RequestBody IdeaCreation ideaCreation) {
    ResponseEntity<String> response = new ResponseEntity<String>("Idea creation failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (ideaService.createIdea(ideaCreation)) {
      response = new ResponseEntity<String>("Idea created successfully", HttpStatus.OK);
    }
    return response;
  }

  @RequestMapping(path = "/{ideaId}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deleteIdea(@PathVariable("ideaId") Integer ideaId, HttpServletResponse response) {
    ResponseEntity<String> resp = new ResponseEntity<String>("Idea deleted failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (ideaService.deleteIdea(ideaId)) {
      resp = new ResponseEntity<String>("Idea deleted successfully", HttpStatus.OK);
    }
    return resp;
  }

  @RequestMapping(path = "/", method = RequestMethod.PUT)
  public ResponseEntity<?> updateIdea(@Valid @RequestBody IdeaAdminUpdateModel ideaAdminUpdateModel) {
    ResponseEntity<String> resp = new ResponseEntity<String>("Idea updated failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (ideaService.updateIdea(ideaAdminUpdateModel)) {
      resp = new ResponseEntity<String>("Idea updated successfully", HttpStatus.OK);
    }
    return resp;
  }

  @RequestMapping(path = "/disable/", method = RequestMethod.POST)
  public ResponseEntity<?> disableIdea(@Valid @RequestBody IdeaDisableModel ideaDisableModel) {
    ResponseEntity<?> responseEntity = new ResponseEntity<>("Idea disable Failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (ideaService.disableIdea(ideaDisableModel)) {
      responseEntity = new ResponseEntity<>("Idea disabled", HttpStatus.OK);
    }
    return responseEntity;
  }

  @RequestMapping(path = "/enable/", method = RequestMethod.POST)
  public ResponseEntity<?> enableIdea(@Valid @RequestBody IdeaEnableModel ideaEnableModel) {
    ResponseEntity<?> responseEntity = new ResponseEntity<>("Idea enable Failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (ideaService.enable(ideaEnableModel)) {
      responseEntity = new ResponseEntity<>("Idea enabled", HttpStatus.OK);
    }
    return responseEntity;
  }

}
