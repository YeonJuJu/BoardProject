package com.juju.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juju.spring.dao.TopMenuDAO;
import com.juju.spring.dto.BoardInfoDTO;

@Service
public class TopMenuService {
	
	@Autowired
	private TopMenuDAO topMenuDAO;
	
	public List<BoardInfoDTO> getTopMenuList(){
		
		List<BoardInfoDTO> topMenuList = topMenuDAO.getTopMenuList();
		
		return topMenuList;
	}
}
