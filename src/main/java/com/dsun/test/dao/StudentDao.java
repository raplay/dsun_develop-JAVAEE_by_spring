package com.dsun.test.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.dsun.test.entity.Student;

import antlr.collections.List;

public interface StudentDao extends PagingAndSortingRepository<Student, Integer> {

	/**
	 * 根据年龄查询所有学生
	 * @param age
	 * @return
	 */
	List findByAge(int age);

	/**
	 * 根据姓名进行模糊查询
	 * @param name
	 * @return
	 */
	List findByNameLike(String name);
	
	
}
