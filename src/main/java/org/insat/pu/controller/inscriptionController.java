package org.insat.pu.controller;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import org.apache.commons.io.IOUtils;
import org.insat.pu.entity.*;
import org.insat.pu.metier.UserManager;

@Controller
public class inscriptionController extends WebMvcConfigurerAdapter{
	@Autowired
	private UserManager metier;
	 

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
    }
   
	@RequestMapping(value="/inscrit_babysitter", method = RequestMethod.GET)
	public String inscrire_Pr(Model model) {
		User u1 = new User();
		model.addAttribute("babysitter",u1);
		return "inscriB";
	}
	
	@RequestMapping(value="/inscrit_parent", method = RequestMethod.GET)
	public String inscrire_BS(Model model) {
		User P = new User();
		model.addAttribute("parent",P);
		return "inscriP";
	}
	
	
	@RequestMapping(value="/inscrit_parent", method = RequestMethod.POST)
	public String inscrireFromForm(@Valid User user, BindingResult result) {
		if (result.hasErrors()) {
			return "inscriP";
		}else {
			Long id = (long) 2;
			user.setActived(true);
			metier.ajouterUser(user);
			User_Role Ur = new User_Role(user.getIdUser(),id);
			metier.ajouterUser_Role(Ur);
		return "index" ;
		}
	}
	@RequestMapping(value="/inscrit_babysitter", method = RequestMethod.POST)
	public String inscrireFrom(@Valid User user, BindingResult result,MultipartFile file, Model model)throws Exception{ 
		if (result.hasErrors()) {
			return "inscriB";
		}
		if(!file.isEmpty()){ user.setPhoto(file.getOriginalFilename()); }
		if(user.getIdUser()==null){
			Long id = (long) 1;
			user.setActived(true);
			metier.ajouterUser(user); 
			User_Role Ur = new User_Role(user.getIdUser(),id);
			metier.ajouterUser_Role(Ur);
			
		} else{ metier.modifierUser(user); }
		if(!file.isEmpty()){
		String path=System.getProperty("java.io.tmpdir")+"/PROD_"+user.getIdUser();
		file.transferTo(new File(path+file.getOriginalFilename()));
		}
		return "index" ;
		
		}
	}
	
	

   
	



