package com.racic.lib.webapp.controller;

import com.racic.lib.client.*;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class MemberController {


	/**
	 * /login will be shown when the login button is clicked
	 * @return login page
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "member/login";
	}

	/**
	 * this method will be called when submit button from login page is clicked
	 * @param request
	 * @param member
	 * @return
	 */
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, com.racic.lib.client.Member member){
		//String referer = request.getHeader("Referer");

		Integer result;
		ModelAndView modelAndView = null;
		String username=member.getUsername();
		String password=member.getPassword();



		if(member !=null && username !=null & password !=null) {

			//call the webservice client
			MemberWeb memberWeb = new MemberWeb();
			MemberWs memberWs = memberWeb.getMemberWsPort();

			/*
			SessionWeb sessionWeb = new SessionWeb();
			SessionWs sessionWs = sessionWeb.getSessionWsPort();
			*/

			//call the webmethod
			//and creation of a new session
			result = memberWs.isValidUser(username,password);
			//boolean validsession = sessionWs.checkSession(member);
			if (result !=null) {

				modelAndView = new ModelAndView("member/profile");
				//modelAndView = new ModelAndView("redirect:" + referer);
				com.racic.lib.client.Member memberConnected = memberWs.findByUsernameAndPassword(username, password);
				request.getSession().setAttribute("connected", true);
				request.getSession().setAttribute("memberConnected", memberConnected);
				//request.getSession().setAttribute("validsession",validsession);
				//com.racic.lib.client.Member loggedInMember = (com.racic.lib.client.Member) request.getSession().getAttribute("memberConnected");
				modelAndView.addObject("memberConnected", memberConnected);


				System.out.println(memberConnected.getFirstName());

			} else {
				modelAndView = new ModelAndView("member/login");
				modelAndView.addObject("msg","Wrong username and or password");
			}
		} else {
			modelAndView = new ModelAndView("library/error");
		}
		return modelAndView;
	}

	@RequestMapping(value="/profile")
	public ModelAndView getprofile(HttpServletRequest request) {
		ModelAndView mv = null;
		if (request!=null && request.getSession().getAttribute("connected") != null) {
			mv = new ModelAndView("member/profile");
			com.racic.lib.client.Member memberConnected = (com.racic.lib.client.Member)request.getSession().getAttribute("memberConnected");
			mv.addObject("memberConnected",memberConnected);
		} else {
			mv = new ModelAndView("library/error");
		}

		return mv;
	}

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		com.racic.lib.client.Member m1 =(com.racic.lib.client.Member)request.getSession().getAttribute("memberConnected");
		System.out.println("before logged out " + m1.getFirstName());
		ModelAndView modelAndView = new ModelAndView("member/login");
		modelAndView.addObject("msg","You are successfully logged out!");

		request.getSession().invalidate();

		return modelAndView;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update() {
		return "member/editprofile";
	}


	@RequestMapping(value="/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView();
		com.racic.lib.client.Member loggedIn =(com.racic.lib.client.Member)request.getSession().getAttribute("memberConnected");
		MemberWeb memberWeb = new MemberWeb();
		MemberWs memberWs = memberWeb.getMemberWsPort();

		if (loggedIn!=null) {
			loggedIn.setFirstName(request.getParameter("firstname"));
			loggedIn.setLastName(request.getParameter("lastname"));
			loggedIn.setAddress(request.getParameter("address"));
			memberWs.updateMember(loggedIn);
			mv.addObject("memberConnected", loggedIn);
			mv.setViewName("member/profile");
		}
		else {
			mv = new ModelAndView("library/error");
		}
		return mv;
	}


}
