package com.users.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.users.beans.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {
	
	Contact findByUserIdAndId(long userId, long id);
	List<Contact> findByUserIdAndLastName(long userId, String LastName);
	List<Contact> findByUserIdAndEmail(long userId, String email);
	List<Contact> findAllByUserIdOrderByFirstNameAscLastNameAsc(long userId); //Creating a list of all users in alphabetical order first then last
	
}