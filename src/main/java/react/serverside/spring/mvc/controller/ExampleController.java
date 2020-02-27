package react.serverside.spring.mvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExampleController {
	@RequestMapping(path = "/example/draw-example.do", method = RequestMethod.GET)
	public ModelAndView drawExample(ModelAndView mv) {
		
		System.out.println("잘 들어 오는군?");
		
		mv.setViewName("/example/example");
		return mv;
	}
	
	@RequestMapping(path = "/example/session-invalidate-test.do", method = RequestMethod.GET)
	public ModelAndView sessionInvalidateTest(ModelAndView mv, HttpSession session) {
		
		System.out.println("session id: \n" + session.getId());
		
		session.setAttribute("a", 123);
		int a = (int) session.getAttribute("a");
		System.out.println(String.valueOf(a == 123));
		
		session.invalidate(); // 세션 무효화
		
		// 아이디는 아직 그대로
		System.out.println("session id after invalidate: \n" + session.getId());
				
		mv.setViewName("/example/example");
		return mv;
	}
}
