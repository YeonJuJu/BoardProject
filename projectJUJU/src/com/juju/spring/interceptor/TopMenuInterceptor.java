package com.juju.spring.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.juju.spring.dto.BoardInfoDTO;
import com.juju.spring.dto.UserDTO;
import com.juju.spring.service.TopMenuService;

public class TopMenuInterceptor implements HandlerInterceptor{

	private TopMenuService topMenuService;
	private UserDTO loginUserDTO;
	
	public TopMenuInterceptor(TopMenuService topMenuService, UserDTO loginUserDTO) {
		this.topMenuService = topMenuService;
		this.loginUserDTO = loginUserDTO;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
		
		List<BoardInfoDTO> topMenuList = topMenuService.getTopMenuList();
		request.setAttribute("topMenuList", topMenuList);
		request.setAttribute("loginUserDTO", loginUserDTO);
		
		return true;
	}
}
