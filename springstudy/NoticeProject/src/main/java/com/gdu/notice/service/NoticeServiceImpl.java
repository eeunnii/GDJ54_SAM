package com.gdu.notice.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.gdu.notice.domain.NoticeDTO;
import com.gdu.notice.mapper.NoticeMapper;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper mapper;
	
	@Override
	public void findAllNotices(Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void findNoticeByNo(int noticeNo, Model model) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNotice(NoticeDTO notice, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyNotice(NoticeDTO notice, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeNotice(int noticeNo, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
