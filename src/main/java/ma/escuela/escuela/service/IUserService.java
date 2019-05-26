package ma.escuela.escuela.service;

import ma.escuela.escuela.domain.User;
import ma.escuela.escuela.dto.ProfileDTO;
import ma.escuela.escuela.exception.NotFoundException;
import ma.escuela.escuela.exception.ServiceException;

import java.util.List;

public interface IUserService {

    User addUser(User user) throws ServiceException;

    User findUser(long id) throws NotFoundException;

    List<User> findAllUsers();

    void deleteUser(long id) throws NotFoundException;

    List<User> searchUsers(User userDto) throws NotFoundException;

    User updateUser(User user) throws NotFoundException;

    User findUserByUsername(String username) throws NotFoundException;

    User getConnectedUser() throws NotFoundException;

    User updateUserProfile(ProfileDTO user);
}
