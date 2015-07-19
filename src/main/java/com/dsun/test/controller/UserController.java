package com.dsun.test.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dsun.test.entity.Profile;
import com.dsun.test.entity.Student;
import com.dsun.test.services.UserService;
	
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService us;
	
	@ResponseBody
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public Map<String,Object> register(/*Student s*/){
		Map<String,Object> map = new HashMap<String,Object>();
		String tip = "添加成功";
		int error = 0;
		
		Student ss = new Student();
		ss.setName("dsun");
		ss.setAge(30);
		
		Profile pro = new Profile();
		pro.setHigh("1.78m");
		pro.setWeight("150kg");
		
		pro.setStudent(ss);
		ss.setProfile(pro);
		
		boolean b = us.saveStudent(ss);
		if(!b){
			tip = "添加失败";
			error ++;
		}
		
		map.put("tip", tip);
		map.put("error", error);
		
		return map;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/pageList",method={RequestMethod.POST,RequestMethod.GET})
	public Map<String,Object> pageList(@RequestParam(value="page",required=true) int page,@RequestParam(value="size",required=true) int size){
		Map<String,Object> map = new HashMap<String,Object>();
		String tip = "查询成功";
		int error = 0;
		

		map.put("studentLisst", us.pageList(page, size));
		
		map.put("tip", tip);
		map.put("error", error);
		
		return map;
	}
}
