package jh.jhspring.Repository;

import java.util.Optional;

import jh.jhspring.domain.Member;

public interface MemberRepository {

	Member save(Member member);
	Optional<Member> findByName(String name);
}
