package com.other;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DemoApplication;

import javax.annotation.Resource;

@Controller
@RequestMapping("/nihao")
public class NihaoController {

	public NihaoController() {
		// TODO Auto-generated constructor stub
	}

    @Autowired
    private MessageSource messageSource;

//    @Resource
//    private LocaleMessage localeMessage;

    @RequestMapping("/lang")
    @ResponseBody
    public String lang(){

        String lang = "";
        Locale locale = LocaleContextHolder.getLocale();
        if ( locale != null )
        {
//            lang = locale.getLanguage();
            lang = locale.toString();
            System.out.println("lang: " + lang);
        }

        return lang;
    }

    @RequestMapping("/msg")
    @ResponseBody
    public String msg( String key ){

        String msg3 = "[]"; //localeMessage.getMessage("welcome");

        String code = "user.title";
        if (!StringUtils.isEmpty(key ) )
		{
			code = key;
		}
        Object [] args = null;
        String defaultMessage = "default";
        Locale locale = LocaleContextHolder.getLocale();

        msg3 = messageSource.getMessage(code,args, defaultMessage,locale);
//
//        System.out.println(msg3);
        return msg3;
    }

//	@Authority(AuthorityType.Validate)
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
		
		return "{name:nihao0}";
	}

	
//	@Authority(AuthorityType.Validate)
	@ResponseBody
	@RequestMapping(value = "/nihao", produces = "application/json;charset=UTF-8", method = { RequestMethod.GET })
	public String nihao() {
		int code = -1;
		String msg = "";


		Map<String, Object> responseMap = new HashMap<String, Object>();
		responseMap.put("code", code);
		responseMap.put("msg", msg);
		responseMap.put("params", "");
		responseMap.put("rows", "");
		
		return "{name:nihao}";
	}
}
