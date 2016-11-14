package com.users.repositories;

//import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.users.beans.Group;
//import com.users.beans.User;

public interface GroupRepository extends CrudRepository<Group, Long> {

//	List<Group> findByLastNameOrFirstNameOrEmailOrTwitterHandleOrFacebookUrlIgnoreCase(
//			String lastName, String firstName, String email, String twitterHandle, String facebookUrl);
//
//	List<Group> findByEmail(String email);
//
//	List<Group> findAllBy();
}
