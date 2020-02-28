package react.serverside.mvc.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExampleController {
	private static final Logger logger = LoggerFactory.getLogger(ExampleController.class);

	private ExampleController() {}

//	@RequestMapping(path = "/example/draw-example.do", method = RequestMethod.GET)
	@GetMapping("/example/draw-example.do")
	public ModelAndView drawExample(ModelAndView mv) {
		
		logger.debug("잘 들어 오는군?");
		
		mv.setViewName("/example/example");
		return mv;
	}
	
//	@RequestMapping(path = "/example/session-invalidate-test.do", method = RequestMethod.GET)
	@GetMapping("/example/session-invalidate-test.do")
	public ModelAndView sessionInvalidateTest(ModelAndView mv, HttpSession session) {
		
		logger.info("session id: \n{}", session.getId());
		
		session.setAttribute("a", 123);
		int a = (int) session.getAttribute("a");
		logger.info(String.valueOf(a == 123));
		
		session.invalidate(); // 세션 무효화
		
		// 아이디는 아직 그대로
		logger.info("session id after invalidate: \n{}", session.getId());
				
		mv.setViewName("/example/example");
		return mv;
	}
}
