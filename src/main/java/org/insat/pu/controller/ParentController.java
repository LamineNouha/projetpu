package org.insat.pu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.insat.pu.entity.User;
import org.insat.pu.metier.UserManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
@RequestMapping("/EspaceParent")
public class ParentController {
	
	@Autowired
	private  UserManager metier;
		
	@RequestMapping("GestionCompte")
		public String EspaceParent(Model model)
		{
			  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		      String name = auth.getName();
			model.addAttribute("current", metier.getUserN(name).get(0));
			return "EspaceParent";
		}
	@RequestMapping(value="GestionCompte/save")
		public String enregistrer(@Valid User current, BindingResult bindingResult,MultipartFile file, Model model) throws Exception{
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	      String name = auth.getName();
	      
			if(bindingResult.hasErrors()) 
			{ model.addAttribute("current", current); }
			if(current.getIdUser()== null)
			{ System.out.println("ok");}
			else {metier.modifierUser(current);}
			model.addAttribute("current", current);
			return "EspaceParent";
		}
		
		@RequestMapping(value="GestionCompte/delete")
		public String delete(@RequestParam("id")Long id,Model model){
		metier.supprimerUser(id);
		return "index";
		}
		@RequestMapping(value="GestionCompte/edit")
		public String edit(@RequestParam("id")Long id,@RequestParam String password, Model model){
		    User U = metier.getUser(id);
		    model.addAttribute("current",U);
		    if (U.getPassword().equals(password))
		    { 
			return "EditParent";}
		    else 
		    {
		    return "EspaceParent";}
		}
		
		@RequestMapping("")
		public String index(Model model){
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		     String name = auth.getName();
			model.addAttribute("current", metier.getUserN(name).get(0));
		model.addAttribute("babysitters", metier.listBabySitters());
		return "EspaceParent";
		}

		@RequestMapping("/babysittersParsexe")
		public String BabysittersParsexe(@RequestParam String sexe,Model
		model){
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		      String name = auth.getName();
			model.addAttribute("current", metier.getUserN(name).get(0));
		model.addAttribute("babysitters",metier.BabySittersParSexe(sexe));
		return "EspaceParent";
		}
		
		@RequestMapping("/babysittersParAge")
		public String BabysittersParAge(@RequestParam int ageMax,@RequestParam int ageMin,Model
		model){
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		      String name = auth.getName();
			model.addAttribute("current", metier.getUserN(name).get(0));
			if (ageMin>ageMax){
				model.addAttribute("babysitters",metier.BabySittersParAge(0,1));
				return "EspaceParent";
			}
			else {
		model.addAttribute("babysitters",metier.BabySittersParAge(ageMin,ageMax));
		return "EspaceParent";}
		}
		@RequestMapping("/chercherBabysitters")
		public String chercherBabysitter(@RequestParam String mc,Model model){
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		      String name = auth.getName();
			model.addAttribute("current", metier.getUserN(name).get(0));
		model.addAttribute("babysitters", metier.BabySittersParMotCle(mc));
		return "EspaceParent";
		}
		
		@RequestMapping("/babysittersParAdresse")
		public String BabysittersParAdressse(@RequestParam String adresse,Model
		model){
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		      String name = auth.getName();
			model.addAttribute("current", metier.getUserN(name).get(0));
		model.addAttribute("babysitters",metier.BabySittersParAdresse(adresse));
		return "EspaceParent";
		}

		@RequestMapping("/Details")
		public String DetailsBs(@RequestParam("id")Long id,Model model){
			 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		      String name = auth.getName();
		model.addAttribute("current", metier.getUserN(name).get(0));
		model.addAttribute("p",metier.getUser(id));
		return "DetailsBabysitter";
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
