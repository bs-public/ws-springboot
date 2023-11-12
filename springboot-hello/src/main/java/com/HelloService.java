package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	private static final Logger log = LoggerFactory.getLogger(HelloService.class);
	
	public static final String MSG = "Hello World";

	public String getMessage() {
		log.info(MSG);
		return MSG;
	}

}
