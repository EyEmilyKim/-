package com.newlecture.web.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

@Mapper
public interface NoticeDao {
	
//	@Results({
//		@Result(property = "regdate", column = "reg_date"),
//		@Result(property = "memberName", column = "member_name")
//	})
	@Select("Select * from noticeview")
	List<NoticeView> getList();

	Notice get(int id);
	

}
