package com.uca.capas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.dao.StudentDAO;
import com.uca.capas.domain.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.validation.Valid;



@Controller
public class MainController {
	
	@Autowired
	private StudentDAO studentDao;
	
	//Objeto Logger
	static Logger log = Logger.getLogger(MainController.class.getName());
	
	@RequestMapping("/")
	public ModelAndView initMain() {
		log.info("Entrando a funcion init-main " + log.getName());
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			//Se seleccionan todos los estudiantes
			students = studentDao.findAll();
			log.info("Termino de buscar en la base de datos");
		} 
		catch (Exception e) {
			log.log(Level.SEVERE,"Exception Occur",e);
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
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public ModelAndView saveStudent(@Valid @ModelAttribute("student") Student s, BindingResult r){
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		if(r.hasErrors()){
			mav.setViewName("editStudent");
		}
		else{
			studentDao.save(s, 0);
			students = studentDao.findAll();
			mav.addObject("students",students);
			mav.setViewName("main");
		}
		
		return mav;
	}
	
	@RequestMapping(value="/formData")
	public ModelAndView save(@ModelAttribute Student s) {
		ModelAndView mav = new ModelAndView();
		List<Student> students = null;
		try {
			log.info("Agregando usuario");
			studentDao.save(s, 1);
		}catch(Exception e) {
			log.info("Error"+e.toString());
		}
		students = studentDao.findAll();
		log.info(students.get(0).getlName());
		mav.addObject("students",students);
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping("/editStudent")
	public ModelAndView editarStudent(@RequestParam("cStudent") Integer cStudent){
		ModelAndView mav = new ModelAndView();
		Student s = studentDao.findOne(cStudent);
		mav.addObject("student", s);
		mav.setViewName("editStudent");
		return mav;
	}
	
}
