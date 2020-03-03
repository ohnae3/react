package react.serverside.support;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperFactory {
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ObjectMapperFactory.class);

	private ObjectMapperFactory() {}

	private static ObjectMapper mapper;

	public static ObjectMapper getMapper() {
		if (mapper == null) {
			mapper = new ObjectMapper();
			customize();
		}
		return mapper;
	}

	private static void customize() {
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNRESOLVED_OBJECT_IDS, false);
		mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
	}
}
