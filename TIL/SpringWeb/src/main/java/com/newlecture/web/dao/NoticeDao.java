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

	List<NoticeView> getViewList(int offset, int size, String field, String query);
	int getCount(String field, String query);

	NoticeView getView(int id);
	Notice getNext(int id);
	Notice getPrev(int id);
	
	int updatePubAll(int[] pubIds, int[] closeIds);
	int deleteAll(int[] ids);
	int update(Notice notice);
	int delete(int id);
	int insert(Notice notice);
}
