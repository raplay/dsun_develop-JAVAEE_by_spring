package com.dsun.test.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dsun.test.dao.ProfileDao;
import com.dsun.test.dao.StudentDao;
import com.dsun.test.entity.Profile;
import com.dsun.test.entity.Student;
import com.dsun.test.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private StudentDao sd;
	
	@Autowired
	private ProfileDao pd;
	
	public boolean saveStudent(Student s) {
		Student student = sd.save(s);
		logger.debug("保存成功!");
		return student.getId() > 0 ? true : false;
	}
	
	public boolean saveProfile(Profile p) {
		Profile profile = pd.save(p);
		logger.debug("保存成功!");
		return profile.getId() > 0 ? true : false;
	}

	public List<Student> pageList(int page, int size) {
		Pageable pageable = new PageRequest(page, size);
		Page<Student> pageStudent = sd.findAll(pageable);
		return pageStudent.getContent();
	}
}
