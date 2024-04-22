package jh.jhspring.Repository;

import java.util.List;
import java.util.Optional;

import jh.jhspring.domain.Post;



public interface PostRepository {

	Post save(Post post);
	void deleteById(Long id);
	
	
	//Post delete(Post post);
	
	//Optional<Post> findByName(String name);
	Optional<Post> findById(Long id);
	List<Post> findAll();
}
