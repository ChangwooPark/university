package com.MusicStore.Controller;

import java.util.ArrayList;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.MusicStore.Model.Member;
import com.MusicStore.Model.contact;
import com.MusicStore.dao.MemberDAO;
import com.MusicStore.daoImpl.MemberDAOImpl;

@Controller
public class MemberController {

	@Autowired
	// 자동연결
	private MemberDAO MemberDAO;

	@RequestMapping(value = "Member/NewMember", method = RequestMethod.GET, produces = "text/plain; charset=UTF-8")
	public ModelAndView NewMemberPage() {

		return new ModelAndView("member/NewMember");
	}

	@RequestMapping(value = "Member/NewMember_Process", method = {
			RequestMethod.GET, RequestMethod.POST }, produces = "text/plain; charset=UTF-8")
	public ModelAndView NewMemberPage(Member member) throws Exception {
		System.out.println(org.springframework.core.SpringVersion.getVersion());
		ModelAndView modelandview = new ModelAndView("member/Login");
		String NewMember_1 = "회원 가입이 되었습니다.";
		String NewMember_2 = "로그인 후 사용해주세요.";
		MemberDAO.addMember(member);
		modelandview.addObject("NewMember_1", NewMember_1);
		modelandview.addObject("NewMember_2", NewMember_2);

		return modelandview;
	}

	@RequestMapping(value = "Member/login", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "text/plain; charset=UTF-8")
	public String loginPage() throws Exception {

		return "member/Login";

	}

	@RequestMapping(value = "Member/loginaction", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "text/plain; charset=UTF-8")
	public ModelAndView loginAction(Member member, HttpSession session)
			throws Exception {

		String id, pass;
		id = member.getId();
		pass = member.getPass();

		List<Member> selectmembers = MemberDAO.getMembers();

		for (int i = 0; i < selectmembers.size(); i++) {
			if (id.equals(selectmembers.get(i).getId())
					&& pass.equals(selectmembers.get(i).getPass())) {
				session.setAttribute("id", selectmembers.get(i).getId());
				session.setAttribute("pass", selectmembers.get(i).getPass());
				session.setAttribute("name", selectmembers.get(i).getName());
				session.setAttribute("address", selectmembers.get(i)
						.getAddress());
				session.setAttribute("e_mail", selectmembers.get(i).getE_mail());
				session.setAttribute("phone", selectmembers.get(i).getPhone());
				session.setAttribute("member_idx", selectmembers.get(i)
						.getMember_idx());

				System.out.println("member_idx : "
						+ selectmembers.get(i).getMember_idx());

				ModelAndView modelandview = new ModelAndView("home");

				return modelandview;
			}

		}

		int idpasscheck = 1;
		ModelAndView modelandview = new ModelAndView("member/Login");
		modelandview.addObject("idpasscheck", idpasscheck);

		return modelandview;
	}

	@RequestMapping(value = "Member/Delete", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "text/plain; charset=UTF-8")
	public String DeletePage() throws Exception {

		return "member/Delete";

	}

	@RequestMapping(value = "Member/Deleteaction", method = RequestMethod.POST)
	public ModelAndView DeleteAction(
			@ModelAttribute("contact") contact contact, BindingResult result,
			HttpSession session) {
		System.out.println(contact.getPass1() + " " + contact.getPass2());
		int idx = (int) session.getAttribute("member_idx");
		Member member = new Member();

		if (contact.getPass1().equals(contact.getPass2())) {
			ModelAndView modelandview = new ModelAndView("home");
			member.setMember_idx((int) session.getAttribute("member_idx"));
			member.setId(session.getAttribute("id").toString());
			member.setPass(session.getAttribute("pass").toString());
			member.setAddress(session.getAttribute("address").toString());
			member.setName(session.getAttribute("name").toString());
			member.setPhone(session.getAttribute("phone").toString());
			member.setE_mail(session.getAttribute("e_mail").toString());
			MemberDAO.deleteMember(member);
			session.invalidate();
			return modelandview;
		}

		ModelAndView modelandview = new ModelAndView("Member/Deleteaction");
		return modelandview;
	}

	
	@RequestMapping(value = "Member/ModifyAction", method = {
			RequestMethod.GET, RequestMethod.POST }, produces = "text/plain; charset=UTF-8")
	public ModelAndView ModifyAction(Member member, HttpSession session)
			throws Exception {

		System.out.println("회원정보수정");
		String id, pass;

		Member memberModify = new Member();

		memberModify.setId(session.getAttribute("id").toString());
		memberModify.setPass(session.getAttribute("pass").toString());

		List<Member> selectmembers = MemberDAO.getMembers();

		for (int i = 0; i < selectmembers.size(); i++) {
			if (session.getAttribute("id").toString()
					.equals(selectmembers.get(i).getId())) {

				session.setAttribute("id", selectmembers.get(i).getId());
				session.setAttribute("pass", member.getPass());
				session.setAttribute("name", selectmembers.get(i).getName());
				session.setAttribute("address", member.getAddress());
				session.setAttribute("e_mail", member.getE_mail());
				session.setAttribute("phone", member.getPhone());
				session.setAttribute("member_idx", selectmembers.get(i)
						.getMember_idx());
				String address = member.getAddress();
				System.out.println(address);

				ModelAndView modelandview = new ModelAndView("home");

				member.setId(selectmembers.get(i).getId().toString());
				member.setPass(member.getPass());
				member.setName(selectmembers.get(i).getName().toString());
				member.setAddress(member.getAddress());
				member.setE_mail(member.getE_mail());
				member.setPhone(member.getPhone());
				member.setMember_idx((int) selectmembers.get(i).getMember_idx());
				MemberDAO.updateMember(member);

				return modelandview;
			}
		}
		return null;
	}

	@RequestMapping(value = "Member/logout", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "text/plain; charset=UTF-8")
	public String LogoutPage(HttpSession session) throws Exception {
		session.invalidate();
		return "member/Logout";
	}

}
