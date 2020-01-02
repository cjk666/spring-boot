package com.entor.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entor.entity.User;

@Controller
public class HelloController {
	
	private List<User> list = new ArrayList<>();

	@RequestMapping("/hello")
	public String  hello(Model model) {
		Random ra = new Random();
		for (int i = 0; i < 10; i++) {
			User u = new User();
			u.setId(i);
			u.setName("测试名字"+i);
			u.setAge(ra.nextInt(10)+15);
			u.setSex(ra.nextInt(2));
			u.setBirthday(new Date());
			u.setPhone("1817696"+(ra.nextInt(8999)+1000));
			list.add(u);
		}
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping("/deleteById")
	public String deleteById(String id,Model model) {
		list.remove(Integer.parseInt(id));
		for (User user : list) {
			System.out.println(user);
		}
		model.addAttribute("list", list);
		return "index";
	}	
	
}
