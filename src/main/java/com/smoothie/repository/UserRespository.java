package com.smoothie.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.smoothie.beans.User;

public interface UserRespository extends CrudRepository<User, Long> {

	List<User> findByLastName(String lastName);
}
