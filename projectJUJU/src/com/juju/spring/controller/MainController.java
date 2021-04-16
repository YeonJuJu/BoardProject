package com.juju.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.juju.spring.dao.TopMenuDAO;
import com.juju.spring.dto.BoardInfoDTO;
import com.juju.spring.dto.ContentDTO;
import com.juju.spring.service.MainService;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	@Autowired
	private TopMenuDAO topMenuDAO;
	
	@GetMapping("/main")
	public String main(HttpServletRequest request, Model model) {
		
		List<List<ContentDTO>> listAll = new ArrayList<List<ContentDTO>>();
		
		for(int i=1;i<5;i++) {
			List<ContentDTO> mainList = mainService.getMainList(i);
			listAll.add(mainList);
		}
		model.addAttribute("listAll", listAll);
		
		List<BoardInfoDTO> boardNameList = topMenuDAO.getTopMenuList();
		model.addAttribute("boardNameList", boardNameList);
		
		return "main";
	}
}
