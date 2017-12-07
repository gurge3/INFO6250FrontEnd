package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import controller.person.PersonModel;
import controller.role.RoleModel;
import controller.user.UserCreation;
import controller.user.UserDisableModel;
import controller.user.UserEnableModel;
import controller.user.UserModel;
import controller.user.UserResponse;
import controller.user.UserUpdateModel;
import dao.PersonDao;
import dao.RoleDao;
import dao.UserDao;
import entity.PersonEntity;
import entity.RoleEntity;
import entity.UserEntity;

@Service
public class UserService {

  @Autowired
  private UserDao userDao;

  @Autowired
  private RoleDao roleDao;

  @Autowired
  private PersonService personService;

  @Autowired
  private PersonDao personDao;

  @Transactional
  public UserEntity findOne(Integer userId) {
    return userDao.findOne(userId);
  }

  @Transactional
  public UserModel createUserWithPerson(UserCreation userCreation) {

    if (userDao.findUserByUsername(userCreation.getUsername()) != null) {
      return null;
    }
    RoleEntity role = roleDao.findOne(userCreation.getRoleId());

    UserModel userProfile = null;

    if (role != null) {

      UserEntity userEntity = new UserEntity();
      userEntity.setUsername(userCreation.getUsername());
      userEntity.setPassword(userCreation.getPassword());
      userEntity.setCreatedOn(new Timestamp(new Date().getTime()));
      userEntity.setRole(role);
      Integer personId = userCreation.getPersonId();
      if (personId != null) {
        PersonEntity person = personDao.findOne(userCreation.getPersonId());
        if (personDao.findOne(personId) == null) {
          return null;
        } else {
          userEntity.setPerson(person);
        }
      } else {
        personId = personService.createPerson(userCreation);
        System.out.println("Person created " + personId);
        PersonEntity person = personDao.findOne(personId);
        userEntity.setPerson(person);
      }
      userEntity = userDao.save(userEntity);
      userProfile = new UserModel();
      userProfile.setUserId(userEntity.getUserId());
      userProfile.setUsername(userEntity.getUsername());

      RoleModel roleModel = new RoleModel(role.getRoleId());
      roleModel.setRoleName(role.getRoleName());
      roleModel.setRoleDesc(role.getRoleDesc());
      userProfile.setRole(roleModel);

    } else {
      return null;
    }
    return userProfile;
  }

  @Transactional
  public UserResponse validateUser(String username, String password) {
    UserEntity userEntity = userDao.findUserByUsername(username);
    if (userEntity == null) {
      return null;
    } else {
      if (!userEntity.getPassword().equals(password)) {
        return null;
      }
      UserResponse response = new UserResponse();
      response.setUsername(userEntity.getUsername());
      response.setRoleName(userEntity.getRole().getRoleName());
      return response;
    }
  }

  @Transactional
  public List<UserEntity> findAll() {
    return userDao.findAll();
  }

  @Transactional
  public boolean deletedUser(Integer userId) {
    userDao.delete(userId);
    return true;
  }


  @Transactional
  public boolean updateUserRole(Integer userId, Integer roleId) {
    UserEntity userEntity = userDao.findOne(userId);
    RoleEntity newRole = roleDao.findOne(roleId);
    if (newRole != null) {
      userEntity.setRole(newRole);
      userDao.save(userEntity);
      return true;
    } else {
      return false;
    }
  }

  @Transactional
  public boolean updateUserName(Integer userId, String username) {
    // Can't update username if this username exists in the database.
    if (userDao.findUserByUsername(username) != null) {
      return false;
    }
    UserEntity userEntity = userDao.findOne(userId);
    userEntity.setUsername(username);
    userDao.saveAndFlush(userEntity);
    return true;
  }

  public boolean disableUser(UserDisableModel userDisableModel) {
    Integer userId = userDisableModel.getUserId();
    String reason = userDisableModel.getDisableReason();

    UserEntity user = userDao.findOne(userId);
    if (user == null) {
      return false;
    } else {
      user.setStatus("disabled");
      user.setOperationReason(reason);
      userDao.saveAndFlush(user);
      return true;
    }
  }

  public boolean enableUser(UserEnableModel userEnableModel) {
    UserEntity user = userDao.findOne(userEnableModel.getUserId());
    if (user == null) {
      return false;
    } else {
      user.setOperationReason(null);
      user.setStatus(null);
      userDao.saveAndFlush(user);
      return true;
    }
  }

  public boolean updateUser(UserUpdateModel userUpdateModel) {
    Integer id = userUpdateModel.getUserId();
    UserEntity user = userDao.findOne(id);
    if (user == null) {
      return false;
    } else {
      user.setPassword(userUpdateModel.getPassword());
      userDao.saveAndFlush(user);
      return true;
    }
  }
}
