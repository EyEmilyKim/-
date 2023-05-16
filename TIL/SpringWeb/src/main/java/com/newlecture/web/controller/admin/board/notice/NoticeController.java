package com.newlecture.web.controller.admin.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.newlecture.web.entity.NoticeView;
import com.newlecture.web.service.NoticeService;

@RequestMapping("/admin/board/notice/")
@Controller("adminNoticeController")
public class NoticeController {

	@Autowired
	private NoticeService service;
	
	@RequestMapping("list")
	public String list(Model model) {
		
		int page = 1;
		String field = "title";
		String query = "";
		boolean pub = false;
		
		List<NoticeView> list = service.getViewList(page, field, query, pub);
		
		model.addAttribute("list", list);
		return "admin.board.notice.list";
	}
	
	@RequestMapping("detail")
	public String detail() {
		
		NoticeView notice = service.getView(1);
		
		return "admin.board.notice.detail";
	}
	
	@RequestMapping("reg")
	public String reg() {
		return "admin.board.notice.reg";
	}
}
