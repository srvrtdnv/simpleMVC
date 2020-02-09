package srvrtdnv;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Component("viewResolver")
public class ViewResolver extends UrlBasedViewResolver {
	
	public ViewResolver() {
		super();
		super.setViewClass(JstlView.class);
		super.setSuffix(".jsp");
		super.setPrefix("/WEB-INF/views/");
	}
	
}
