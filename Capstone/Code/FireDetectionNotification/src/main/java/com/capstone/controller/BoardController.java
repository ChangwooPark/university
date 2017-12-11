package com.capstone.controller;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

	@RequestMapping(value = "/board/NoticeUi.do", method = RequestMethod.GET)
	public ModelAndView NoticeUi() {
		ModelAndView mav = new ModelAndView("/board/NoticeUi");
		return mav;
	}
	
	@RequestMapping(value = "/board/HelpUi.do", method = RequestMethod.GET)
	public ModelAndView HelpUi() {
		ModelAndView mav = new ModelAndView("/board/HelpUi");
		return mav;
	}

}
