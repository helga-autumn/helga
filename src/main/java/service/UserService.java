package service;

import java.util.List;

import com.entity.User;

public interface UserService {

	void insertUser(String firstName, int idInt);

	List<User> getAllUsers();

}
