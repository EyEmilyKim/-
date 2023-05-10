package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.NoticeView;

public interface NoticeService {

	// - 목록 페이지를 요청할 때
	List<NoticeView> getViewList();

	int getCount();

	// - 검색을 요청할 때
	List<NoticeView> getViewList(String field, String query);

	// - 페이지 버튼 눌러 요청할 때
	List<NoticeView> getViewList(int page, String field, String query);

	int getCount(String field, String query);

	// - 자세한 페이지 요청할 때
	NoticeView get(int id);

	Notice getNext(int id);

	Notice getPrev(int id);

	// - 일괄공개를 요청할 때
	int updatePubAll(int[] pubIds, int[] closeIds);

	// - 일괄삭제를 요청할 때
	int deleteAll(int[] ids);

	// - 수정 페이지 요청할 때
	int update(Notice notice);

	int delete(int id);

	// - 목록에서 글쓰기 버튼
	int insert(Notice notice);

}
