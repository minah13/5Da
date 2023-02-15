package spring.project.da.domain.home.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import spring.project.da.domain.auth.dto.SessionUser;


@Slf4j
@RequiredArgsConstructor
@Controller
public class HomeController {
	
	private final HttpSession httpSession;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String home(Model model) {
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		
		if(user != null) {
			model.addAttribute("userName",user.getName());
		}
		
		log.info("homeController start");
		
		return "index";
	}
	
}
