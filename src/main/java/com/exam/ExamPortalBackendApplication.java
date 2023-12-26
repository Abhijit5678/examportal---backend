package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.Model.Role;
import com.exam.Model.User;
import com.exam.Service.UserService;

@SpringBootApplication
public class ExamPortalBackendApplication  implements CommandLineRunner{
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user =new User();
		user.setId(1l);
		user.setFirstname("Abhijit");
		user.setLastname("Samantaray");
		user.setPassword("abhi@123");
		user.setPhone("87563465834");
		user.setEmail("abhi@gmail.com");
		user.setEnable(false);
		user.setUsername("abhi");
//		user.setUserRoles(null);
		Role role=new Role();
		role.setRoleid(1l);
		role.setRolename("Admin");
//		Set<UserRole> userRoleset=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role);
//		userRole.setUser(user);
//		userRoleset.add(userRole);
		
//	 	User user2=this.userService.saveUser(user, userRoleset);
	}

}
