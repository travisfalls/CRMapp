package com.users.security;

import static com.users.security.Role.ROLE_ADMIN;
import static com.users.security.Role.ROLE_USER;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.users.repositories.ContactRepository;
import com.users.repositories.UserRepository;

//Used on service-layer classes to specify intent
@Service 
public class PermissionService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ContactRepository contactRepo;
	
	private UsernamePasswordAuthenticationToken getToken() { //User to present simple username and password
		return (UsernamePasswordAuthenticationToken) //returning the username and password
		getContext().getAuthentication();
	}
	
	public boolean hasRole(Role role) {
		for(GrantedAuthority ga : getToken().getAuthorities()){ //iterating through users
			if(role.toString().equals(ga.getAuthority())){ //checking for user's role
				return true;
			}
		}
		return false;
	}
	
	public boolean canAccessUser(long userId) {
		return hasRole(ROLE_ADMIN) || (hasRole(ROLE_USER) && findCurrentUserId() == userId);
	}
	
	public long findCurrentUserId(){
		return userRepo.findByEmail(getToken().getName()).get(0).getId();
	}

	public boolean canEditContact(long contactId) {
		return hasRole(ROLE_USER) && contactRepo.findByUserIdAndId(findCurrentUserId(), contactId) != null;
	}
	
	

}
