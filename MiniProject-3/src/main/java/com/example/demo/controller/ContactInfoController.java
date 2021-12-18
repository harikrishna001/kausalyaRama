package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactService;

@Controller
public class ContactInfoController {

	
	public ContactService contactService;
	
	//constructor emdukamte alraedy cheppanu pina controller ki service object ravali @Autowired pettaladu kabatti ela manually ga consturctor use chesi service object ni controller loki thechhukumtunnam ok
	public ContactInfoController(ContactService contactService)
	{
		this.contactService=contactService;
	}
	
	
	
	
	@GetMapping("/loadForm")
	public String loadForm(Model model)  // eyokka method contact object ni form page lo pedathadi ok.
	{
		Contact cobj=new Contact();
		
		model.addAttribute("contact",cobj); // model object is used to send the data controller to view
		
		return "contact";
	}
	
	
	
	@PostMapping("/saveContact")
	public String handleSaveBtnClick(Contact contact,Model model) // model emdukamte object save ayethe save ayyemdi ani kimda message rasam danini send chesthadi view ki ok.
	{
	Boolean isSaved=	contactService.saveContact(contact);
	
	if(isSaved)
	{
		model.addAttribute("sucessMsg","contact saved successfully");
	} else
	{
		model.addAttribute("errMsg","Failed To Save Contact");
	}
		return "contact";
	}
	
	
	
	//below method is responsible to retrive the data in the form of model and view object.
	
	@GetMapping("/viewContacts")
public ModelAndView  handleViewAllContacts()
{
	ModelAndView mav=new ModelAndView();
	
List<Contact> allContacts=contactService.getAllContacts();


mav.addObject("contacts",allContacts);// key sir data ayokka page lo eyokka key dwara render

mav.setViewName("viewContacts"); // ikkada modelandview object lo viewname set chesam ekkadiki povali object ani set chesam  viewname ok.
	return mav;
}
	
	/*controller numchi data pampataniki normal ga [model] object vadatham kani edi second approach evidam ga kuda modelandview object use
	
	chesi kuda datani pampavcahhu amte ikkada [model +view] both objects vunnaye so controller will return modeland view object kalipi anuko. emthakamundu
			
			imko paddathilo[model] object vumdi kimda return"index" ela rasthe amte ayokka model ayokka view ki povali ani controller ardam chesukumatdi alane send kani second
					
					approach controller direct ga written [modelandview] then we no need take any parameter ayokka object lone [model parameter] [viewname]  anni ayokka objectlone vunnaye so
					
					
					controller just return that object. edi kuda emthakamundu vadam manam ok*/
}
