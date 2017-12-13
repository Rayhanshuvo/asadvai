package com.crud.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.entity.PersonForm;
import com.crud.service.ManageService;


@Controller
public class Controllerjava {
	
	@Autowired
	private ManageService sr;

	@RequestMapping("/")
	public String showMypage(){
		
	return "form";	
		
	}
	//HttpServletRequest request.....................>>>>>>>>>Holds html form data
	@PostMapping("/processForm")
	//public String letsShout(HttpServletRequest request, Model model){
	public String letsShout(Model model, @Valid @ModelAttribute("roleEntity") PersonForm personForm,
			BindingResult bindingResult){
		System.err.println(personForm.getFirstname()+ personForm.getSecondname());
		
		/*String thename= request.getParameter("studentname");*/
        sr.save(personForm);
        
		return "results";
		
	}
   
}