package jh.jhspring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpSession;
import jh.jhspring.Service.MemberService;
import jh.jhspring.domain.Member;

@Controller
public class MemberController {

	private final MemberService memberService;

	private PasswordEncoder passwordEncoder;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
		passwordEncoder = new BCryptPasswordEncoder();
	}

	@GetMapping("register_form")
	public String register_form() {
		return "member/Registerform.html";
	}

	@PostMapping("register_form")
	public String register_ok(MemberForm form) {
		if (form.getPassword().length() >= 1 && form.getPassword().length() <= 10) {
			Member member = new Member();
			String pwd = passwordEncoder.encode(form.getPassword());
			member.setName(form.getName());
			member.setPassword(pwd);
			memberService.register(member);
		} else {
			throw new IllegalStateException();
		}

		return "redirect:/";
	}

	@GetMapping("login_form")
	public String login(HttpSession session) {
		if (session.getAttribute("login") == null) {
			return "member/LoginForm.html";
		} else {
			return "redirect:/";
		}
	}

	@PostMapping("login_form")
	public String login_ok(MemberForm form, HttpSession session) {
		if (session.getAttribute("login") == null) {

			Member result = memberService.login(form);
			memberService.login(form);

			if (result != null) {
				session.setAttribute("login", result);
			} else {
				throw new IllegalStateException(); // null시 예외처리 페이지
			}
		}
		return "redirect:/";
	}

	@GetMapping("logout_form")
	public String logout_ok(HttpSession session) {
		if (session.getAttribute("login") != null) {
			session.removeAttribute("login");
		}
		return "redirect:/";
	}
}
