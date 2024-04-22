package jh.jhspring.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jh.jhspring.domain.Member;




public interface SpringDataJpaMemberRepository extends JpaRepository<Member,Long>,MemberRepository {

}

