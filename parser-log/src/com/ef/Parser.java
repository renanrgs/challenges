package com.ef;

import static com.ef.util.DateUtil.TIME_STAMP_PATTERN;
import static com.ef.util.DateUtil.formatDate;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ef.model.AccessDTO;
import com.ef.service.AccessService.TypeDuration;
import com.ef.service.AccessServiceImpl;

public class Parser {

	/**
	 * Take the parameters sent by user and execute each task required by test
	 * @param args parameters sent by user
	 */
	public static void main(String[] args) {
		Map<String, String> parameters = formatParameters(args);
		AccessServiceImpl service = new AccessServiceImpl();
		String file = parameters.get("accesslog");
		LocalDateTime filterDateTime = formatDate(parameters.get("startDate"), TIME_STAMP_PATTERN);
		TypeDuration duration = TypeDuration.valueOf(parameters.get("duration").toUpperCase());
		Integer threshold = Integer.valueOf(parameters.get("threshold")); 
		
		executeOperations(service, file, filterDateTime, duration, threshold); 
	}

	/**
	 * Execute each task required by test
	 */
	private static void executeOperations(AccessServiceImpl service, String file, LocalDateTime filterDateTime,
			TypeDuration duration, Integer threshold) {
		service.loadData(file);
		List<AccessDTO> accesses = service.find(filterDateTime, duration, threshold);
		accesses.forEach(System.out::println);
		service.blockIP(accesses, duration);
	}

	/**
	 * Read parameters from the command line
	 * 
	 * @param args
	 *            parameters passed by user
	 * @return Map of parameters made up of key and value
	 */
	private static Map<String, String> formatParameters(String[] args) {
		return Arrays.asList(args).stream()
				.collect(Collectors.toMap(Parser::generateParameterKey, Parser::generateParameterValue));
	}

	/**
	 * Generate parameter key
	 * 
	 * @param parameter
	 *            passed by user
	 * @return parameter key
	 */
	private static String generateParameterKey(String parameter) {
		return parameter.replace("--", "").split("=")[0];
	}

	/**
	 * Generate parameter value
	 * 
	 * @param parameter
	 * @return parameter value
	 */
	private static String generateParameterValue(String parameter) {
		return parameter.replace("--", "").split("=")[1];
	}

}
