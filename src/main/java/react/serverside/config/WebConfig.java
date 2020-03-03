package react.serverside.config;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@Configuration
@EnableWebMvc // Spring MVC 활성화
@ComponentScan(basePackages = "react.serverside") // component-scan 범위 지정
public class WebConfig implements WebMvcConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(WebConfig.class);

	/**
	 * viewResolver 설정
	 * 
	 * @return
	 * @author fixalot
	 */
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		view.setPrettyPrint(true);
		registry.enableContentNegotiation(view);
		registry.jsp("/WEB-INF/jsp/", ".jsp");
	}

	/**
	 * needed for JSON conversion of bean responses
	 * 
	 * @return
	 * @since 2020-03-03
	 * @author fixalot@lotte.net
	 */
	@Bean
	@Primary
	public View jsonTemplate() {
		logger.info("Registered MappingJackson2JsonView");
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		Properties props = new Properties();
		props.put("order", 1);
		view.setAttributes(props);
		view.setPrettyPrint(true);
		return view;
	}

	/**
	 * DispatcherServlet이 고정적인 리소스들에 대한 요청을 자신이 직접 처리하지 않고 서블릿 컨테이너의 디폴트 서블릿 전달을 요청한다.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

}
