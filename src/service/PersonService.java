package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import controller.person.PersonModel;
import controller.user.UserCreation;
import dao.PersonDao;
import dao.UserDao;
import entity.PersonEntity;
import entity.UserEntity;

@Service
public class PersonService {

	@Autowired
	private PersonDao personDao;

	@Autowired
	private UserDao userDao;

	@Transactional
	public Integer createPerson(PersonModel model) {

		PersonEntity person = new PersonEntity();
		person.setEmail(model.getEmail());
		person.setDob(model.getDob());
		person.setFirstName(model.getFirstName());
		person.setLastName(model.getLastName());

		person = personDao.save(person);
		return person.getPersonId();

	}
	
	@Transactional
	public Integer createPerson(UserCreation model) {

		PersonEntity person = new PersonEntity();
		person.setEmail(model.getEmail());
		person.setDob(model.getDob());
		person.setFirstName(model.getFirstname());
		person.setLastName(model.getLastname());

		person = personDao.saveAndFlush(person);
		System.out.println("--Person ID--" + person.getPersonId());
		return person.getPersonId();

	}

	@Transactional
	public List<PersonModel> findAll() {
		return personDao.findAll().stream().map(person -> {
			PersonModel personModel = new PersonModel();
			personModel.setPersonId(person.getPersonId());
			personModel.setFirstName(person.getFirstName());
			personModel.setLastName(person.getLastName());
			personModel.setEmail(person.getEmail());
			personModel.setDob(person.getDob());
			return personModel;
		}).collect(Collectors.toList());
	}

	@Transactional
	public boolean updatePerson(Integer personId, PersonModel personModel) {

		PersonEntity person = personDao.findOne(personId);
		if (person != null) {
			person.setFirstName(personModel.getFirstName());
			person.setLastName(personModel.getLastName());
			person.setEmail(personModel.getEmail());
			person.setDob(personModel.getDob());
			personDao.save(person);
			return true;

		} else {
			return false;
		}

	}

	@Transactional
	public boolean deletePerson(Integer personId) {
		List<UserEntity> userEntities = userDao.findByPersonId(personId);

		if (userEntities != null && userEntities.isEmpty()) {
			PersonEntity person = personDao.findOne(personId);
			personDao.delete(person);
		} else {
			return false;
		}

		return true;

	}

	@Transactional
	public PersonModel fetchPersonDetails(Integer personId) {
		PersonEntity person = personDao.findOne(personId);
		if (person == null) {
			return null;
		}

		PersonModel personModel = new PersonModel();
		personModel.setPersonId(person.getPersonId());
		personModel.setFirstName(person.getFirstName());
		personModel.setLastName(person.getLastName());
		personModel.setEmail(person.getEmail());
		personModel.setDob(person.getDob());

		return personModel;
	}

}
