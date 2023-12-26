package com.exam.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.exam.Model.Role;
import com.exam.Model.User;
import com.exam.Model.UserRole;
import com.exam.Repository.RoleRepository;
import com.exam.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userrepo;
	@Autowired
	private RoleRepository rolerepo;
	
	 @Autowired
	  private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public User saveUser(User user, Set<UserRole> userRoles) throws Exception {
	    User checkUser = userrepo.findbyUsername(user.getUsername());

	    if (checkUser != null) {
	        System.out.println("User Already Exists");
	    } else {
	        // Create a new set to store roles
	        Set<Role> roles = new HashSet<>();

	        // Save each role and add it to the new set
	        for (UserRole userRole : userRoles) {
	            roles.add(rolerepo.save(userRole.getRole()));
	        }

	        // Now associate the roles with the user and save again to update the join table
	        user.getUserRoles().addAll(roles);
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	        checkUser = userrepo.save(user);
	    }

	    return checkUser;
	}


	@Override
	public List<User> getUserData() {
		
		return userrepo.findAll();
	}

	@Override
	public User getUserById(Long id) {
		
		return userrepo.findById(id).get();
	}

	@Override
	public String deleteDataById(Long id) {
		String status=null;
		userrepo.deleteById(id);
		status="success";
		return status;
	}

	@Override
	public User getUserDataByName(String user) {
		User user2=userrepo.findbyUsername(user);
		return user2;
	}



}
