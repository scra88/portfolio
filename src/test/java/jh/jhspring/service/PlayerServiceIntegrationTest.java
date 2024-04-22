package jh.jhspring.service;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jh.jhspring.Service.MemberService;
import jh.jhspring.Service.PostService;
import jh.jhspring.domain.Member;
import jh.jhspring.domain.Post;
import jh.jhspring.Controller.MemberForm;
import jh.jhspring.Controller.PostForm;
import jh.jhspring.Repository.MemberRepository;
import jh.jhspring.Repository.PostRepository;

@SpringBootTest
@Transactional
public class PlayerServiceIntegrationTest {

	@Autowired
	PostService postService;
	@Autowired
	PostRepository postRepository;

	@Autowired
	MemberService memberService;
	@Autowired
	MemberRepository memberRepository;

	PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	
	@Test
	void posting() {
		Post post = new Post();

		post.setTitle("제123");
		post.setContents("내123123");
		postService.posting(post);

	}

	@Test
	void delete_post() {
		postService.deletePost(14L);
	}

	@Test
	void update_post() {

		PostForm form = new PostForm();
		form.setId(14L);
		form.setTitle("ㅇㅇ");
		form.setContents("ㅎㅇㅎㅇ");

		postService.updatePost(form);
	}

	@Test
	void register_ok() {
		Member member = new Member();
		member.setName("ㅇ1123ㅇ");
		member.setPassword("1257");
		String pwd = passwordEncoder.encode(member.getPassword());
		member.setPassword(pwd);
		memberRepository.save(member);
	}

	@Test
	void password_match() {
		Member member = memberRepository.findByName("dallem").get();	 
		boolean check = passwordEncoder.matches("12345",member.getPassword());
		System.out.println(check);
		//System.out.println(memberService.login());
	}
	
	@Test
	void login()
	{
		MemberForm form = new MemberForm();
		form.setName("dallem");
		form.setPassword("1234");
		System.out.println(memberService.login(form));
	}
}
