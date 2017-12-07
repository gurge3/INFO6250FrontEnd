package controller.category;

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

import entity.CategoryEntity;
import service.CategoryService;

@RestController
@RequestMapping("/category")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @RequestMapping(path = "/", method = RequestMethod.GET)
  public @ResponseBody
  List<CategoryEntity> getAllCategories() {
    return categoryService.findAll();
  }

  @RequestMapping(path = "/{categoryId}", method = RequestMethod.GET)
  public @ResponseBody CategoryEntity getIdeaById(@PathVariable("categoryId") Integer ideaId, HttpServletResponse response) {
    CategoryEntity result = categoryService.findOne(ideaId);
    if (result == null) {
      // Setting 422 to warn the front end.
      response.setStatus(422);
      return null;
    } else {
      return result;
    }
  }

  @RequestMapping(path = "/", method = RequestMethod.POST)
  public ResponseEntity<?> createNewCategory(@Valid @RequestBody CategoryCreation categoryCreation) {
    ResponseEntity<String> response = new ResponseEntity<String>("Category creation failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (categoryService.createCategory(categoryCreation)) {
      response = new ResponseEntity<String>("Category created successfully", HttpStatus.OK);
    }
    return response;
  }

  @RequestMapping(path = "/{categoryId}", method = RequestMethod.DELETE)
  public ResponseEntity<?> deleteCategory(@PathVariable("categoryId") Integer categoryId, HttpServletResponse response) {
    ResponseEntity<String> resp = new ResponseEntity<String>("Category deleted failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (categoryService.deleteCategory(categoryId)) {
      resp = new ResponseEntity<String>("Category deleted successfully", HttpStatus.OK);
    }
    return resp;
  }

  @RequestMapping(path = "/", method = RequestMethod.PUT)
  public ResponseEntity<?> updateCategory(@Valid @RequestBody CategoryUpdateModel categoryUpdateModel) {
    ResponseEntity<String> resp = new ResponseEntity<String>("Category updated failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (categoryService.updateCategory(categoryUpdateModel)) {
      resp = new ResponseEntity<String>("Category updated successfully", HttpStatus.OK);
    }
    return resp;
  }

  @RequestMapping(path = "/{categoryId}", method = RequestMethod.POST)
  public ResponseEntity<?> setStartupWithCategory(@Valid @RequestBody StartupCreation startupCreation,
                                                  @PathVariable("categoryId") Integer categoryId) {
    ResponseEntity<String> response = new ResponseEntity<String>("Category creation failed", HttpStatus.UNPROCESSABLE_ENTITY);
    if (categoryService.setStartup(startupCreation.getUserId(), categoryId)) {
      response = new ResponseEntity<String>("Category created successfully", HttpStatus.OK);
    }
    return response;
  }

}
