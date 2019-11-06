package com.other;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@Controller
public class LoginController {

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

    @Autowired
    private MessageSource messageSource;


	@ResponseBody
	@RequestMapping(value = "", produces = "application/json;charset=UTF-8", method = { RequestMethod.GET })
	public String nihao0() {
		int code = -1;
		String msg = "";

		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("code", code);
		responseMap.put("msg", msg);
		responseMap.put("params", "");
		responseMap.put("rows", "");
		
		return "{name:hello}";
	}
}
