package com.newlecture.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("index")
	public String index() {
		System.out.println("index() called");
		return "root.index";
	}
	
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("IndexController called");
//		ModelAndView mav = new ModelAndView("root.index");
//		mav.addObject("data", "Hello Sping MVC~");
////		mav.setViewName("/WEB-INF/view/index.jsp");
//		return mav;
//	}

}