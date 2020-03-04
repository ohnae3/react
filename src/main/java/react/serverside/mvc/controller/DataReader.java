package react.serverside.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import react.serverside.support.ObjectMapperFactory;

@Controller
public class DataReader {
//	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(DataReader.class);

	ObjectMapper jsonConverter = ObjectMapperFactory.getMapper();

	private DataReader() {}

	@GetMapping(path = "/react/readSample", produces = "application/json")
	public Map<String, Object> readSample(HttpServletResponse resp) throws IOException {
		HashMap<String, Object> json = jsonConverter.readValue(new ClassPathResource("data/sample.json").getFile(), new TypeReference<HashMap<String, Object>>() {});
		logger.debug("{}", json);
		return json;
	}
}
