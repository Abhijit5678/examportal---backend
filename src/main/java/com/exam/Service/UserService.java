package com.exam.Service;

import java.util.List;
import java.util.Set;

import com.exam.Model.Role;
import com.exam.Model.User;
import com.exam.Model.UserRole;

public interface UserService {

	User saveUser(User user,Set<UserRole> userrole) throws Exception;

	List<User> getUserData();

	User getUserById(Long id);

	String deleteDataById(Long id);

	User getUserDataByName(String user);
	
}
