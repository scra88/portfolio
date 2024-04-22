package jh.jhspring.Repository;



import org.springframework.data.jpa.repository.JpaRepository;

import jh.jhspring.domain.Post;


public interface SpringDataJpaPostRepository extends JpaRepository<Post,Long>,PostRepository {

	//ong deleteById(Long id);
	//Optional<Post> findByName(String name);
}
