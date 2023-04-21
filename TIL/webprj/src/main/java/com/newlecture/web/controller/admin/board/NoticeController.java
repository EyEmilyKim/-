package com.newlecture.web.controller.admin.board;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller("adminNoticeController")
@RequestMapping("/admin/board/notice/")
public class NoticeController {
	
	@Autowired
	private ServletContext ctx;
	
//	@RequestMapping("list")
	public String list() {
		
		return "";
	}
	
	@RequestMapping("reg")
	@ResponseBody
	public String reg(String title, String content, MultipartFile file, String category, String[] foods, String food, HttpServletRequest request) throws IllegalStateException, IOException {
		
		long size = file.getSize();
		String fileName = file.getOriginalFilename();
		System.out.printf("filename : %s, filesize : %d\n", fileName, size);
		
		String webPath = "/static/upload";
//		ServletContext ctx = request.getServletContext();
		String realPath = ctx.getRealPath(webPath);
		System.out.printf("realPath : %s\n", realPath);
		//업로드하기 위한 경로가 없을 경우 dir 만들어줘~
		File savePath = new File(realPath);
		if(!savePath.exists())
			savePath.mkdirs();
		
		realPath += File.separator + fileName;
		File saveFile = new File(realPath);
		
		file.transferTo(saveFile);
		
		
		for(String f : foods)
			System.out.println(f);
		System.out.println("food : "+food);
		return String.format("title : %s<br>content : %s<br>category : %s<br>", title, content, category);
	}
	
	@RequestMapping("edit")
	public String edit() {
		
		return "";
	}
	
	@RequestMapping("del")
	public String del() {
		
		return "";
	}
	
}
