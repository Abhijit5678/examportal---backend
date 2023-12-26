package com.exam.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.Model.Role;
import com.exam.Model.User;
import com.exam.Model.UserRole;
import com.exam.Service.UserService;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	
	@ModelAttribute
	public User newUser() {
	    return new User();
	}

	@ModelAttribute
	public HashSet<Role> newRoles() {
	    return new HashSet<>();
	}
	
	@PostMapping("/saveUser")
	public ResponseEntity<User> saveUser(@RequestBody User user)
	{
		
		User userdata=null;
		Set<UserRole> userRoleset=new HashSet<>();
		
		Role role=new Role();
		role.setRoleid(2l);
		role.setRolename("Normal");
		UserRole userRole=new UserRole();
//		userRole.setUser(user);
		userRole.setRole(role);
		userRoleset.add(userRole);
		
		try {
			userdata= userService.saveUser(user,userRoleset);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new ResponseEntity<>(userdata,HttpStatus.OK);
		
	}
	
	@GetMapping("/")
	public ResponseEntity<List<User>> getUser()
	{
		List<User> userdata=null;
		userdata=userService.getUserData();
		
		return new ResponseEntity<>(userdata,HttpStatus.OK);
		
	}
	
	@PutMapping("/updateById/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id)
	{
		User userdata=null;
		
		userdata = userService.getUserById(id);
		
		return new ResponseEntity<>(userdata,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<String> DeleteUser(@PathVariable Long id)
	{
		String userdata=null;
		userdata=userService.deleteDataById(id);
		
		
		return new ResponseEntity<>(userdata,HttpStatus.OK);
		
	}
	
	@GetMapping("/{user}")
	public ResponseEntity<User> getUserByName(@PathVariable String user)
	{
		User userdata=null;
		userdata=userService.getUserDataByName(user);
		
		
		return new ResponseEntity<>(userdata,HttpStatus.OK);
		
	}
	
	
	
}
