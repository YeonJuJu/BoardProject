package com.juju.spring.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import com.juju.spring.dto.ContentDTO;
import com.juju.spring.dto.UserDTO;
import com.juju.spring.service.BoardService;

public class CheckWriterInterceptor implements HandlerInterceptor{
	
	private UserDTO loginUserDTO;
	private BoardService boardService;
	
	public CheckWriterInterceptor(UserDTO loginUserDTO, BoardService boardService) {
		this.loginUserDTO = loginUserDTO;
		this.boardService = boardService;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception{
		
		int content_idx = Integer.parseInt(request.getParameter("content_idx"));
		
		ContentDTO tmpContentDTO = boardService.getContentInfo(content_idx);
		
		if(tmpContentDTO.getContent_writer_idx() != loginUserDTO.getUser_idx()) {
			
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/board/not_writer");
			
			return false;
		}
		
		return true;
	}

}
