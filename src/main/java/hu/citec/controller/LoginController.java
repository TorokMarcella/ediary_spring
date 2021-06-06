package hu.citec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import hu.citec.service.RegistrationService;

@Controller
public class LoginController {
	
	@Autowired
    private HttpServletRequest request;
	
	@Autowired
	private RegistrationService registrationService;
	
	@GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam String username, @RequestParam String password, Model model) {
        if(registrationService.findUser(username, password)) {
            HttpSession session = request.getSession(true);
            session.setAttribute("user", username);
            session.setMaxInactiveInterval(60);
            return "redirect:/users/";
        }
        else {
            model.addAttribute("wrong", "error");
            return "login";
        } 
    }
}
