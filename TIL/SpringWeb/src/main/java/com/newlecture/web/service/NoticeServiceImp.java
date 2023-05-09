package com.newlecture.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Service
public class NoticeServiceImp implements NoticeService {

	@Autowired
	private NoticeDao noticeDao;
	
	@Override
	public List<NoticeView> getList(int page, String field, String query) {
		
		int size = 10;
		int offset = 0+(page-1)*size; // page 1->0, 2->10, 3->20... an=a1(n-1)d -> 0+(page-1)*10
		List<NoticeView> list = noticeDao.getList(offset, size, field, query);
		
		return list;
	}

	@Override
	public Notice get(int id) {
		
		Notice notice = noticeDao.get(id);
		
		return notice;
	}

}
