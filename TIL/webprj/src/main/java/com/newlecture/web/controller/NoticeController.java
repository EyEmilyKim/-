package com.newlecture.web.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

@Controller
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("/notice/list")
	public ModelAndView list() throws ClassNotFoundException, SQLException {
		ModelAndView mav = new ModelAndView("notice.list");
//		mav.setViewName("/WEB-INF/view/notice/list.jsp");
		List<Notice> list = noticeService.getList(1, "title", "");
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping("/notice/detail")
	public String detail() {
		return "notice.detail";
	}

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		// TODO Auto-generated method stub
//		ModelAndView mav = new ModelAndView("notice.detail");
////		mav.setViewName("/WEB-INF/view/notice/detail.jsp");
//		return mav;
//	}

}
