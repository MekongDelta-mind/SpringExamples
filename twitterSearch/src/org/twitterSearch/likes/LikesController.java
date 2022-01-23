package org.twitterSearch.likes;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LikesController {
	
	@RequestMapping("/likes")
	public String showLikePage() {
		System.out.print("Inside like page");
		return "LikesPage";
	}
}
