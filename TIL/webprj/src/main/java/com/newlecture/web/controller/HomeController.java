package com.newlecture.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HomeController {

	@RequestMapping("index")
	@ResponseBody
	public String index() {
		System.out.println("index() called");
		return "Hello Index !";
	}
	
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		System.out.println("IndexController called");
//		ModelAndView mav = new ModelAndView("root.index");
//		mav.addObject("data", "Hello Sping MVC~");
////		mav.setViewName("/WEB-INF/view/index.jsp");
//		return mav;
//	}

}