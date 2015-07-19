package com.dsun.test.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by dulei on 15/7/7.
 * Email:dreamfly@126.com
 * DL~
 * Description:个人基本信息
 */
@Entity
@Table(name = "t_profile")
public class Profile {
	
	@JsonProperty("pid")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;//标志位
	
	@Column(name = "high")
	private String high;//身高
	
	@Column(name = "weight")
	private String weight;//体重
	
	@JsonIgnore
	@Column(name = "createtime")
	private Date createtime = new Date();//创建时间
	
	@JsonIgnore
	@Column(name = "updatetime")
	private Date updatetime = new Date();//修改时间
	
	
	@JsonIgnore
	// optional=true：可选，表示此对象可以没有，可以为null；false表示必须存在
    @OneToOne(cascade = { CascadeType.REFRESH, CascadeType.MERGE }, optional = true)
    @JoinColumn(name = "s_id")
	private Student student;//指定用户


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getHigh() {
		return high;
	}


	public void setHigh(String high) {
		this.high = high;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}


	public Date getUpdatetime() {
		return updatetime;
	}


	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}

	
}
