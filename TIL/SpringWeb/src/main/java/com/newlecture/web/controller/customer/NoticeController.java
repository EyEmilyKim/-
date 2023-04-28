package com.newlecture.web.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer/notice/")
public class NoticeController {

		@RequestMapping("list")
		public String list(Model model) {
			model.addAttribute("test", "Hello DevTools~");
			return "customer.notice.list"; // for TilesViewResolver
//			return "customer/notice/list"; // for ResourceViewResolver
		}
		
		@RequestMapping("detail")
		public String detail() {
			return "customer/notice/detail";
		}
}
