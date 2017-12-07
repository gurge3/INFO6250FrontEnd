package controller.person;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.PersonService;

@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public List<PersonModel> fetchAll(){
		return personService.findAll();
	}
	
	@RequestMapping(path="/{personId}", method=RequestMethod.GET)
	public PersonModel fetchPersonDetails(@PathVariable("personId") Integer personId){
		return personService.fetchPersonDetails(personId);
	}
	
	@RequestMapping(path="/{personId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deletePerson(@PathVariable("personId") Integer personId) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Person delete Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);

		if (personService.deletePerson(personId)) {
			responseEntity = new ResponseEntity<>("Person delete Success",HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path="/{personId}",method = RequestMethod.PUT)
	public ResponseEntity<?> updatePerson(@PathVariable("personId") Integer personId, @RequestBody PersonModel model) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Person update Failed",HttpStatus.UNPROCESSABLE_ENTITY);

		if (personService.updatePerson(personId, model)) {
			responseEntity = new ResponseEntity<>("Person update Success",HttpStatus.OK);
		}
		return responseEntity;
	}
	
	@RequestMapping(path="/", method = RequestMethod.POST)
	public ResponseEntity<?> createPerson(@RequestBody PersonModel model) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("Person create Failed",HttpStatus.UNPROCESSABLE_ENTITY);
		Integer id = personService.createPerson(model);
		if (id != null) {
			responseEntity = new ResponseEntity<>("Person with id: " + id + " has been created successfully",HttpStatus.OK);
		}
		return responseEntity;
	}
		

}
