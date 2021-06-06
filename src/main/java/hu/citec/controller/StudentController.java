package hu.citec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.citec.service.UserService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String findSubjectGrades(Model model, @RequestParam String username, @RequestParam int id) {
		model.addAttribute("subjects", userService.findSubjectsByUserId(id));
		model.addAttribute("grades", userService.findSubjectGrades(username));
		return "/student";
	}
}
