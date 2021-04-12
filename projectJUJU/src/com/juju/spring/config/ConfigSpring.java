package com.juju.spring.config;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;



/* XML방식의 web.xml 역할을 하는 파일 */

public class ConfigSpring extends AbstractAnnotationConfigDispatcherServletInitializer{

	// XML방식의 root-context.xml 역할을 하는 파일 -> RootAppContext.java 지정
	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppContext.class};
	}

	// Spring MVC 에서 사용하는 클래스를 지정함 -> ServletAppContext.java 지정
	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {ServletAppContext.class};
	}
	
	// DispatcherServlet에 mapping 할 주소를 설정 
	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"};
	}

	// 한글처리를 위한 인코딩 필터
	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
		
		encodingFilter.setEncoding("UTF-8");
		
		return new Filter[] {encodingFilter};
	}
	
	// 파일 관련 설정
	@Override
	protected void customizeRegistration(Dynamic registration) {
		
		super.customizeRegistration(registration);
		
		MultipartConfigElement config1 = new MultipartConfigElement(null, 50*1024*1024, 200*1024*1024, 0);
	
		registration.setMultipartConfig(config1);
	}
}
