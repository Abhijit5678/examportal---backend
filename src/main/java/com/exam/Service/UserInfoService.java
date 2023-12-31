package com.exam.Service;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.security.core.userdetails.UserDetails; 
import org.springframework.security.core.userdetails.UserDetailsService; 
import org.springframework.security.core.userdetails.UsernameNotFoundException; 
import org.springframework.security.crypto.password.PasswordEncoder; 
import org.springframework.stereotype.Service;

import com.exam.Model.User;
import com.exam.Model.UserInfoDetails;
import com.exam.Repository.UserRepository;

import java.util.Optional; 

@Service
public class UserInfoService implements UserDetailsService { 

	@Autowired
	private UserRepository repository; 

	@Autowired
	private PasswordEncoder encoder; 

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
//
//		Optional<Employee> userDetail = repository.findByName(username); 
//		System.out.println(userDetail);
////		 Converting userDetail to UserDetails 
//		return userDetail.map(UserInfoDetails::new) 
//				.orElseThrow(() -> new UsernameNotFoundException("User not found " + username)); 
//	} 
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Optional<User> userDetail = repository.findByName(username);

	    if (userDetail.isPresent()) {
	        // Converting userDetail to UserDetails
	        return new UserInfoDetails(userDetail.get());
	    } else {
	        throw new UsernameNotFoundException("User not found with username: " + username);
	    }
	}


//	public String addUser(UserInfo userInfo) { 
//		userInfo.setPassword(encoder.encode(userInfo.getPassword())); 
//		repository.save(userInfo); 
//		return "User Added Successfully"; 
//	} 


} 

