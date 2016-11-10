package com.users.security;

import static com.users.security.Role.ROLE_ADMIN;
import static com.users.security.Role.ROLE_USER;
import static org.springframework.security.core.context.SecurityContextHolder.getContext;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.users.beans.User;
import com.users.repositories.ContactRepository;
import com.users.repositories.UserRepository;

//Used on service-layer classes to specify intent
@Service 
public class PermissionService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ContactRepository contactRepo;
	
	private AbstractAuthenticationToken getToken() { //User to present simple username and password
		return (AbstractAuthenticationToken) //returning the username and password
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
		List<User> users = userRepo.findByEmail(getToken().getName());
		return users !=null && !users.isEmpty() ? users.get(0).getId() :-1;
	}
	
	
	public User findCurrentUser() {
		List<User> users = userRepo.findByEmail(getToken().getName());
		return users != null && !users.isEmpty() ? users.get(0) : new User();
	}

	public boolean canEditContact(long contactId) {
		return hasRole(ROLE_USER) && contactRepo.findByUserIdAndId(findCurrentUserId(), contactId) != null;
	}
	
	public String getCurrentEmail() {
		return getToken().getName();
	}
	
	

}
