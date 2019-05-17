package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.*;

@Controller
public class MainController {
	
	@Autowired
	private StudentDAO studentDao;
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			students = studentDao.findAll();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/buscarestudiante")
	public ModelAndView buscarEstudiante(@RequestParam Integer code) {
		ModelAndView mav = new ModelAndView();
		Student s = studentDao.findOne(code);
		if(s == null) {
			mav.addObject("resultado",0);
			mav.setViewName("student");
		} else {
			mav.addObject("student",s);
			mav.setViewName("student");
		}
		return mav;
	}
}
