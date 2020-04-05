package com.icypt.sboot.controller;

import com.icypt.sboot.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class TestController {
	@Autowired
	MessageSource messageSource;

	@RequestMapping("/")
	public String index(Model model) {
		return "forward:index";
	}

	@RequestMapping("/index")
	public String toIndex(Model model, HttpSession session) {
		List<Person> personList = new ArrayList<>();
		Person person = new Person("1","张三", "大小伙");
		Person person1 = new Person("2","李四", "大姑娘");
		Person person2 = new Person("3","王五", "小孩儿");
		personList.add(person);
		personList.add(person1);
		personList.add(person2);
		model.addAttribute("person", person);
		model.addAttribute("testVariables", "测试");
		model.addAttribute("cssStyle", "cssStyle");
		model.addAttribute("testClass", "testClass");
		model.addAttribute("personList", personList);
		model.addAttribute("currentTime", new Date());
		session.setAttribute("sessionAttr", "sessionAttr");
		ServletContext servletContext = session.getServletContext();
		servletContext.setAttribute("applicationAttr", "applicationAttr");
		Map<String, Object> map = new HashMap<>();
		map.put("id", 1);
		map.put("name", "张三");
		map.put("desc", "大小伙");
		model.addAttribute("personMap", map);
		return "index";
	}

}
