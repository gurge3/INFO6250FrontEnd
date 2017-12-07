package controller.user;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

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

import entity.UserEntity;
import service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> createUserWithPerson(@Valid @RequestBody UserCreation userCreation) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("UserEntity Creation Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		UserModel userProfile = null;
		if ((userProfile = userService.createUserWithPerson(userCreation)) != null) {
			responseEntity = new ResponseEntity<>("UserEntity created Successfully", HttpStatus.OK);
		}
		return responseEntity;
	}

	@RequestMapping(value = "/validate", method = RequestMethod.POST)
	public @ResponseBody UserResponse getUser(@Valid @RequestBody ValidateUserModel userModel, HttpServletResponse response) {
		UserResponse model = null;
		if ((model = userService.validateUser(userModel.getUsername(), userModel.getPassword())) != null) {
			return model;
		}
		response.setStatus(422);
		return null;
	}
	
	@RequestMapping(path = "/{userId}/username", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUsername(@NotNull @PathVariable("userId") Integer userId, @RequestBody UserWithUserName userWithUserName) {
		ResponseEntity<String> response = new ResponseEntity<String>("Username update failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		if (userService.updateUserName(userId, userWithUserName.getUsername())) {
			response = new ResponseEntity<String>("Update successfully", HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = "/", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody UserUpdateModel userUpdateModel) {
		ResponseEntity<String> response = new ResponseEntity<String>("User update failed",
						HttpStatus.UNPROCESSABLE_ENTITY);
		if (userService.updateUser(userUpdateModel)) {
			response = new ResponseEntity<String>("Update successfully", HttpStatus.OK);
		}
		return response;
	}
	
	@RequestMapping(path = "/{userId}/role", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUserRole(@NotNull @PathVariable("userId") Integer userId,
			@RequestBody UserModel userModel) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("UserEntity(role) updated Failed",
				HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (userService.updateUserRole(userId, userModel.getRole().getRoleId())) {
			responseEntity = new ResponseEntity<>("UserEntity(role) updated", HttpStatus.OK);
		}
		return responseEntity;
	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> updateUserRole(@NotNull @PathVariable("userId") Integer userId) {

		ResponseEntity<?> responseEntity = new ResponseEntity<>("UserEntity delete Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		;
		if (userService.deletedUser(userId)) {
			responseEntity = new ResponseEntity<>("UserEntity Deleted", HttpStatus.OK);
		}
		return responseEntity;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<UserEntity> findAll() {
		return userService.findAll();
	}

	@RequestMapping(path = "/{userId}", method = RequestMethod.GET)
	public UserEntity findOne(@NotNull @PathVariable("userId") Integer userId) {
		return userService.findOne(userId);
	}

	@RequestMapping(path = "/disable/", method = RequestMethod.POST)
	public ResponseEntity<?> disableUser(@Valid @RequestBody UserDisableModel userDisableModel) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("User disable Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		if (userService.disableUser(userDisableModel)) {
			responseEntity = new ResponseEntity<>("User disabled", HttpStatus.OK);
		}
		return responseEntity;
	}

	@RequestMapping(path = "/enable/", method = RequestMethod.POST)
	public ResponseEntity<?> enableUser(@Valid @RequestBody UserEnableModel userEnableModel) {
		ResponseEntity<?> responseEntity = new ResponseEntity<>("User enable Failed", HttpStatus.UNPROCESSABLE_ENTITY);
		if (userService.enableUser(userEnableModel)) {
			responseEntity = new ResponseEntity<>("User enabled", HttpStatus.OK);
		}
		return responseEntity;
	}

}
