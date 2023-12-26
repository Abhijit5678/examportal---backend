package com.exam.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exam.Jwt.AuthRequest;
import com.exam.Jwt.JwtService;
import com.exam.Model.Response;
import com.exam.Model.User;
import com.exam.Repository.UserRepository;
import com.exam.Service.UserInfoService;

@CrossOrigin
@RestController

public class AuthController {

	@Autowired
	private JwtService jwtService; 

	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@Autowired
	private UserInfoService userDetailsService; 
	
	@Autowired
	private UserRepository userrepo;
	
	@PostMapping("/generateToken")
	public ResponseEntity<Response> authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
	    try {
	        Response response = new Response<>();
	        Authentication authentication = authenticationManager.authenticate(
	                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
	        );

	        if (authentication.isAuthenticated()) {
	            response.setMessage(jwtService.generateToken(authRequest.getUsername()));
	            return new ResponseEntity<>(response, HttpStatus.OK);
	        } else {
	            throw new BadCredentialsException("Invalid username or password");
	        }
	    } catch (BadCredentialsException e) {
	        throw e;
	    } catch (UsernameNotFoundException e) {
	    	
	        Response response = new Response<>();
	        response.setMessage("User not found");
	        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	    } catch (AuthenticationException e) {
	        throw new BadCredentialsException("Invalid username or password", e);
	    }
	}
	@GetMapping("/current-user")
	public  User getCurrentUser(Principal prinicipal)
	{
		
		User checkUser = userrepo.findbyUsername(prinicipal.getName());
		return checkUser;
//		return (User) this.userDetailsService.loadUserByUsername(prinicipal.getName());
	}
}
