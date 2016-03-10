package com.smoothie.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.smoothie.beans.UserImage;

public interface UserImageRepository extends CrudRepository<UserImage, Long> {

	List<UserImage> findByUserId(long userId);
}
