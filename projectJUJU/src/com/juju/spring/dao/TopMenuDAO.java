package com.juju.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.juju.spring.dto.BoardInfoDTO;
import com.juju.spring.mapper.TopMenuMapper;

@Repository
public class TopMenuDAO {
	
	@Autowired
	private TopMenuMapper topMenuMapper;
	
	public List<BoardInfoDTO> getTopMenuList(){
		
		List<BoardInfoDTO> topMenuList = topMenuMapper.getTopMenuList();
		
		return topMenuList;
	}
}
