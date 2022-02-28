package com.netcore.minimum;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeCOVIDController {

	
	@RequestMapping(value="getTotal/{state}", method=RequestMethod.GET)
	@ResponseBody
	public String showHomePage(@PathVariable("state") String state) {
		System.out.println("HomePage code Working");
		System.out.println("State name: "+ state);
		DetailsProcessor details = new DetailsProcessor();
		details.queryState = state;
		
		String result = String.valueOf(details.total_vacc_for_state);
		return result;
	}

	//adding the next method to this Class itself
}
