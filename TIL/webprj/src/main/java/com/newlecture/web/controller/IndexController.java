package com.newlecture.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class IndexController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("IndexController called");
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("data", "Hello Sping MVC~");
//		mav.setViewName("/WEB-INF/view/index.jsp");
			return mav;
	}
}
