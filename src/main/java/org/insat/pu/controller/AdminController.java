package org.insat.pu.controller;

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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.insat.pu.entity.User;
import org.insat.pu.metier.UserManager;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	@Autowired
	private  UserManager metier;
	
	
	@RequestMapping("")
	public String EspaceAdmin(Model model)
	{
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
		model.addAttribute("current", metier.getUserN(name).get(0));
		return "EspaceAdmin";
	}
	@RequestMapping(value="save")
	public String enregistrer(@Valid User current, BindingResult bindingResult,MultipartFile file, Model model) throws Exception{
	 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
      String name = auth.getName();
      
		if(bindingResult.hasErrors()) 
		{ model.addAttribute("current", current); }
		if(current.getIdUser()== null)
		{ System.out.println("ok");}
		else {metier.modifierUser(current);}
		model.addAttribute("current", current);
		return "EspaceAdmin";
	}
	@RequestMapping(value="delete")
	public String delete(@RequestParam("id")Long id,Model model){
	metier.supprimerUser(id);
	return "index";
	}
	@RequestMapping(value="edit")
	public String edit(@RequestParam("id")Long id,@RequestParam String password, Model model){
	    User U = metier.getUser(id);
	    model.addAttribute("current",U);
	    if (U.getPassword().equals(password))
	    { 
		return "EditAdmin";}
	    else 
	    {
	    return "EspaceAdmin";}
	}
	
	
	/*@RequestMapping(value="/photoBB",produces=MediaType.IMAGE_JPEG_VALUE)
	@ResponseBody
	public byte[] getPhoto(Long id) throws IOException{
	User j= metier.getUser(id);
	File f =new File(System.getProperty("java.io.tmpdir")+"/PROD_"+id+j.getPhoto());
    return IOUtils.toByteArray(new FileInputStream(f));
	}*/
	
	
	
	@RequestMapping(value="/suppBB")
	public String deleteBB(@RequestParam("id")Long id,Model model){
	metier.supprimerUser(id);
	model.addAttribute("babysitters", metier.listBabySitters());
	return "Babysitters";
	}
	
	@RequestMapping(value="/suppPar")
	public String deletePr(@RequestParam("id")Long id,Model model){
	metier.supprimerUser(id);
	model.addAttribute("parents",metier.listParents());
	return "Parents";
	}
	@RequestMapping(value="/BBs")
	public String affich_bb(Model model){
	model.addAttribute("babysitters",metier.listBabySitters());
	return "Babysitters";
	}
	@RequestMapping(value="/Parents")
	public String affich_par(Model model){
	model.addAttribute("parents",metier.listParents());
	return "Parents";
	}


	
	
	


}
