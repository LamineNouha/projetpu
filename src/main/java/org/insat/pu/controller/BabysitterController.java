package org.insat.pu.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.apache.commons.io.IOUtils;
import org.insat.pu.entity.User;
import org.insat.pu.entity.User_Role;
import org.insat.pu.metier.UserManager;

@Controller
@RequestMapping("/EspaceBabysitter")
public class BabysitterController {
	
	@Autowired
	private  UserManager metier;
		
	@RequestMapping("")
		public String EspaceBabysitter(Model model)
		{
			  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		      String name = auth.getName();
			model.addAttribute("current", metier.getUserN(name).get(0));
			return "EspaceBabysitter";
		}
	@RequestMapping(value="save")
		public String enregistrerBs(@Valid User current, BindingResult bindingResult,MultipartFile file, Model model) throws Exception{
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
	      
			if(bindingResult.hasErrors()) 
			{ model.addAttribute("current", current);}
			if(!file.isEmpty()){ current.setPhoto(file.getOriginalFilename()); }
			if(current.getIdUser()==null){
			}
			else{ metier.modifierUser(current); }
			if(!file.isEmpty()){
			String path=System.getProperty("java.io.tmpdir")+"/PROD_"+current.getIdUser();
			file.transferTo(new File(path+file.getOriginalFilename()));
			}
			
			return "EspaceBabysitter";
		}
		
		@RequestMapping(value="delete")
		public String deleteBs(@RequestParam("id")Long id,Model model){
		metier.supprimerUser(id);
		return "index";
		}
		@RequestMapping(value="edit")
		public String editBs(@RequestParam("id")Long id,@RequestParam String password, Model model){
		    User U = metier.getUser(id);
		    model.addAttribute("current",U);
		    if (U.getPassword().equals(password))
		    { 
			return "EditBabysitter";}
		    else 
		    {
		    return "EspaceBabysitter";}
		}
		
		 @RequestMapping(value="/photo",produces=MediaType.IMAGE_JPEG_VALUE)
			@ResponseBody
			public byte[] getPhoto(@RequestParam ("idJ") Long idJ) throws IOException{
		    System.out.println("heloooooo");
			User j=metier.getUser(idJ);
			File f =new File(System.getProperty("java.io.tmpdir")+"/PROD_"+idJ+j.getPhoto());
		
		    return IOUtils.toByteArray(new FileInputStream(f));
			}
}
