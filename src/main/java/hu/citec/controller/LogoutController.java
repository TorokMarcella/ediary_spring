package hu.citec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
	
	@Autowired
	private HttpServletRequest request;
	
	@GetMapping("/")
	public String logout(Model model) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "redirect:/login";
	}

}
