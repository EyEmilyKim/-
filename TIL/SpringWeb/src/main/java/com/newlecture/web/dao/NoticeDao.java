package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;

public interface NoticeDao {
	@Select("Select * from notice")
	List<Notice> getList();

	Notice get(int id);
	

}
