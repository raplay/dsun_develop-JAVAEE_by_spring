package com.dsun.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.dsun.test.entity.Profile;

public interface ProfileDao extends CrudRepository<Profile, Integer> {

	

}
