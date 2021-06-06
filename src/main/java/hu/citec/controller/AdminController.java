package hu.citec.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.citec.entity.User;
import hu.citec.service.UserService;

@Controller
@RequestMapping("/users")
public class AdminController {
	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public String users(Model model) {
		if(request.getSession(true).getAttribute("user") != null) {			
			model.addAttribute("users", userService.listAllUser());
			return "users";
		}
		return "redirect:/users";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUserById(@PathVariable int id,  Model model) {
		if(request.getSession(true).getAttribute("user") != null) {	
			userService.deleteUserById(id);
			return "redirect:/users";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/delete/{roleId}")
	public String deleteUserByRole(@PathVariable int id,  Model model) {
		if(request.getSession(true).getAttribute("user") != null) {	
			userService.deleteUserById(id);
			return "redirect:/users";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/new")
	public String addUser(Model model) {
			model.addAttribute("user", new User());
			return "add-user";
	}
	
	@PostMapping("/new")
	public String userAdd(@ModelAttribute User user, Model model) {
		if (request.getSession(true).getAttribute("user") != null) {
			userService.addUser(user);
			return "redirect:/add-user";
		}
		return "redirect:/login";
	}
	
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable User user, Model model) {
		if(request.getSession(true).getAttribute("user") != null) {	
			userService.editUser(user);
			return "user-edit";
		}
		return "redirect:/login";
	}
}
