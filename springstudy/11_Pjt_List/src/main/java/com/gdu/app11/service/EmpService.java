package com.gdu.app11.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface EmpService {
	public void getAllEmployees(HttpServletRequest request, Model model);
	public Map<String, Object> getAutoCompleteList(HttpServletRequest request);
	public void findEmployees(HttpServletRequest request, Model model);
}
