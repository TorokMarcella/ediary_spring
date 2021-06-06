package hu.citec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.citec.entity.User;
import hu.citec.entity.UserRole;
import hu.citec.service.RegistrationService;
import hu.citec.service.UserService;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registration(@ModelAttribute User user, @ModelAttribute UserRole userRole) {
		registrationService.registration(user);
		userService.addRole(userRole);
		
		return "redirect:/login";
	}
}
