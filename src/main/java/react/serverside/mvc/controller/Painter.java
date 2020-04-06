package react.serverside.mvc.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Painter {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(Painter.class);

	private Painter() {}

	@GetMapping("/react/test")
	public ModelAndView test(ModelAndView model) {
		return model;
	}
}
