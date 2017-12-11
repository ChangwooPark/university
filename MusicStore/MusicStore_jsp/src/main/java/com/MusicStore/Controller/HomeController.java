package com.MusicStore.Controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public String loadHomePage(HttpSession session) {
		boolean Is_session;
		if (session != null) {
			Is_session = false;
		} else {
			Is_session = true;
		}
		session.setAttribute("Is_session", Is_session);

		return "home";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public ModelAndView indexPage() {
		return new ModelAndView("home");
	}

	@RequestMapping(value = "main/MainFrame", method = { RequestMethod.POST,
			RequestMethod.GET }, produces = "text/plain; charset=UTF-8")
	public ModelAndView loadMainPage() {

		return new ModelAndView("main/MainFrame");
	}
}
