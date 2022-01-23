package org.twitterSearch.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String showHomePage() {
		// entry point for the website.
		System.out.print("Inside Home page");
		return "HomePage";
	}
}
