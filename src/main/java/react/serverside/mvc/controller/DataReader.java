package react.serverside.mvc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DataReader {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(DataReader.class);

	private DataReader() {}

	@GetMapping(path = "/react/readSample", consumes = "todo")
	public void readSample(HttpServletResponse resp) throws IOException {
		PrintWriter writer = resp.getWriter();
		writer.write("hello!");
		resp.flushBuffer();
	}
}
