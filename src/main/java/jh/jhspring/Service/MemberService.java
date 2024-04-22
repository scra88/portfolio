package jh.jhspring.Service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jh.jhspring.Controller.MemberForm;
import jh.jhspring.Repository.MemberRepository;
import jh.jhspring.domain.Member;

@Service
public class MemberService {

	private final MemberRepository memberRepository;

	private PasswordEncoder passwordEncoder;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
		passwordEncoder = new BCryptPasswordEncoder();

	}

	public Long register(Member member) {

		if (!memberRepository.findByName(member.getName()).isPresent()) {
			memberRepository.save(member);
		} else {
			throw new IllegalStateException();
		}

		return member.getId();
	}

	public Member login(MemberForm form) {

		Optional<Member> member = memberRepository.findByName(form.getName());
		if (member.isPresent()) {
			if (passwordEncoder.matches(form.getPassword(), member.get().getPassword())) {
				return member.get();
			} else {
				return null;
			}
		} else {
			return null;
		}

		// boolean result = passwordEncoder.matches(form.getPassword(),
		// member.getPassword());

		// return result;
	}

}
