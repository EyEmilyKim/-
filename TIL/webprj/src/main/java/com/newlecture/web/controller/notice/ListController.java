package com.newlecture.web.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.service.NoticeService;

public class ListController implements Controller {

	@Autowired
	private NoticeService noticeService;
	
//	@Autowired
//	public void setNoticeService(NoticeService noticeService) {
//		this.noticeService = noticeService;
//		System.out.println("Hello");
//	}



	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		ModelAndView mav = new ModelAndView("notice.list");
//		mav.setViewName("/WEB-INF/view/notice/list.jsp");
		List<Notice> list = noticeService.getList(1, "title", "");
		mav.addObject("list", list);
		return mav;
	}

}
