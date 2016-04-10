package com.marcolenzo.checkip;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckIpController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String checkIp(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

}
