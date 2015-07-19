package com.dsun.test.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by dulei on 15/7/7.
 * Email:dreamfly@126.com
 * DL~
 * Description:账号相关
 */
@Entity
@Table(name = "t_student")
public class Student {
	
	@JsonProperty("aid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;//账户id
	
	@Column(name = "name")
	private String name;//姓名
	
	@Column(name = "age")
	private int age;//年龄
	
	@JsonIgnore
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "student")
	private Profile profile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
