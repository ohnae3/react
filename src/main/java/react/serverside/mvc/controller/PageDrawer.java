package react.serverside.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageDrawer {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(PageDrawer.class);

	private PageDrawer() {}

	@GetMapping("/react")
	public ModelAndView a(ModelAndView model) {
		model.setViewName("react/test");
		return model;
	}
}
