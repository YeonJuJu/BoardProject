package com.juju.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;

import com.juju.spring.dto.UserDTO;

/* XML방식의 root-context.xml 역할을 하는 파일 : bean 정의 */

@Configuration
public class RootAppContext {
	
	@Bean("loginUserDTO")
	@SessionScope
	public UserDTO loginUserDTO() {
		return new UserDTO();
	}
}
