package com.owens.dev;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.owens.service.HomeService;
import com.owens.vo.HomeVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	private HomeService service;
	
	public void setService(HomeService service) {
		this.service = service;
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "main.do", method = RequestMethod.GET)
	public ModelAndView home(Locale locale) {
		ModelAndView mav = new ModelAndView();
		
		log.debug("Welcome home! The client locale is {}.");
		
		List<HomeVO> list = null;
		try{
			System.out.println(service.selectBoardList());
			list = service.selectBoardList();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		mav.addObject("serverTime", formattedDate );
		mav.addObject("list", list);
		
		mav.setViewName("home");
		
		return mav;
	}
	
}
