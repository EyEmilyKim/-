package com.newlecture.web.controller.customer;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.service.NoticeService;

@Controller
@RequestMapping("/customer/notice/")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping("list")
	public String list(String p) throws ClassNotFoundException, SQLException {
		System.out.println("NoticeController > list() called");
//		String p = request.getParameter("p");
		System.out.println("page : "+p);
		
//		List<Notice> list = noticeService.getList(1, "title", "");
		
		return "notice.list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		System.out.println("NoticeController > detail() called");
		return "notice.detail";
	}
	
}
