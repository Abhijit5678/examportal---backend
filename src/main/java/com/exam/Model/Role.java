package com.exam.Model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

@Entity(name = "role")
public class Role {
	@Id
	private Long roleid;
	private String rolename;
	@JsonIgnore
	 @ManyToMany(mappedBy = "userRoles")
	    private Set<User> users = new HashSet<>();
	

	 
	public Role()
	{
		
	}
}
