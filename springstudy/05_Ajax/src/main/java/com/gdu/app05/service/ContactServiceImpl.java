package com.gdu.app05.service;

import java.util.Map;

import com.gdu.app05.domain.Contact;

public class ContactServiceImpl implements ContactService {

	@Override
	public Contact execute1(Contact member) {
		return member;  // 받아 온 거 그대로 보내기
	}
	
	@Override
	public Map<String, Object> execute2(Map<String, Object> map) {
		return map;  // 받아 온 거 그대로 보내기
	}

}
