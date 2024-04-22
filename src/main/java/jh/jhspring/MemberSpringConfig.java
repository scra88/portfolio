package jh.jhspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import jh.jhspring.Repository.MemberRepository;
import jh.jhspring.Repository.PostRepository;




@Configuration
public class MemberSpringConfig {

	private final MemberRepository memberRepository;

	public MemberSpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}
	

	
}