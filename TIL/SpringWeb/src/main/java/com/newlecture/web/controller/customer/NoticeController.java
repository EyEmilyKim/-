package com.newlecture.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/notice/")
public class NoticeController {

		@RequestMapping("list")
		public String list(Model model) {
			model.addAttribute("test", "Hello~");
			return "/WEB-INF/view/customer/notice/list.jsp";
		}
		
		@RequestMapping("detail")
		public String detail() {
			return "/WEB-INF/view/customer/notice/detail.jsp";
		}
}
