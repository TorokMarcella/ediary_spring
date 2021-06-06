package hu.citec.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.citec.entity.SubjectGrade;
import hu.citec.service.UserService;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/add")
	public String addGrade(Model model) {
		if (request.getSession(true).getAttribute("grades") != null) {	
			model.addAttribute("grades", new SubjectGrade());
			return "add-grade";
		}
		return "redirect:/login";
	}
	
	@PostMapping("/add")
	public String gradeCreator(@ModelAttribute SubjectGrade grade, Model model) {
		if (request.getSession(true).getAttribute("grades") != null) {
			userService.addGrade(grade);
			return "redirect:/add-grade";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/")
	public String listAllStudents(Model model) {
		if (request.getSession(true).getAttribute("user") != null) {
			model.addAttribute("user", userService.listAllStudents());
			return "/student";
		}
		return "redirect:/login";
	}
}
