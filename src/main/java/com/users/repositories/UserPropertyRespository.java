package com.users.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.users.beans.UserProperty;

public interface UserPropertyRespository extends CrudRepository<UserProperty, Long> {

	List<UserProperty> findByUserId(int userId);
}
