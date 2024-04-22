package jh.jhspring;


import org.springframework.context.annotation.Configuration;


import jh.jhspring.Repository.PostRepository;


@Configuration
public class PostSpringConfig {

	private final PostRepository postRepository;
	
	
	public PostSpringConfig(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

}
