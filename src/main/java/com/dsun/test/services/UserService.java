package com.dsun.test.services;

import java.util.List;

import com.dsun.test.entity.Student;
import com.dsun.test.entity.Profile;

/**
 * Created by dulei on 15/7/7.
 * Email:dreamfly@126.com
 * DL~
 * Description:此服务层只处理账号信息以及用户的基本信息
 */
public interface UserService {
	
	/**
	 * 保存学生实体
	 * @param s 学生实体
	 * @return 是否保存成功
	 */
	public boolean saveStudent(Student s);
	
	/**
	 * 保存个人信息实体
	 * @param s 个人信息实体
	 * @return 是否保存成功
	 */
	public boolean saveProfile(Profile p);
	
	/**
	 * 实现一个分页操作
	 * @param page 页码
	 * @param size 一页显示数量
	 * @return 学生实体集合
	 */
	public List<Student> pageList(int page,int size);
}
