package spring.project.da.domain.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginPageController {
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginPage() {
		System.out.println("loginPage controller start");
		
		return "index";
	}
}