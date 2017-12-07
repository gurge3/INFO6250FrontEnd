package controller.role;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import service.RoleService;

@RestController
@RequestMapping("/role")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class RoleController {

	@Autowired
	private RoleService roleService;

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity<String> createRole(@RequestBody @Valid RoleModel roleModel) {

		ResponseEntity<String> response = new ResponseEntity<String>("Role Not Created",
				HttpStatus.UNPROCESSABLE_ENTITY);
		if (roleService.createRole(roleModel) != null) {
			response = new ResponseEntity<String>("Role Created", HttpStatus.OK);
		}

		return response;
	}
	
	@ExceptionHandler({DataIntegrityViolationException.class})
	public ResponseEntity<?> handleDuplicateEntry() {
		ResponseEntity<String> response = new ResponseEntity<String>("Duplicate Role",
				HttpStatus.UNPROCESSABLE_ENTITY);
		return response;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<RoleModel> findAll() {
		return roleService.findAll();
	}

	@RequestMapping(path = "/{roleId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteRole(@PathVariable("roleId") Integer roleId) {
		ResponseEntity<?> response = new ResponseEntity<>("Role Not Deleted", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = roleService.deleteRole(roleId);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}

	@RequestMapping(path = "/{roleId}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateRole(@PathVariable("roleId") Integer roleId,
			@RequestBody @Valid RoleModel newRole) {
		ResponseEntity<?> response = new ResponseEntity<>("Role Not Updated", HttpStatus.UNPROCESSABLE_ENTITY);

		boolean deleteStatus = roleService.updateRole(roleId, newRole);
		if (deleteStatus) {
			response = new ResponseEntity<>(deleteStatus, HttpStatus.OK);
		}
		return response;
	}

}
