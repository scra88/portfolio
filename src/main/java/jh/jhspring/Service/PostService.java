package jh.jhspring.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import jh.jhspring.Controller.PostForm;
import jh.jhspring.Repository.PostRepository;
import jh.jhspring.domain.Post;

@Service
public class PostService {

	private final PostRepository postRepository;

	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public Long posting(Post post) {

		postRepository.save(post);

		return post.getId();
	}

	public List<Post> PostList() {
		return postRepository.findAll();
	}

	public void deletePost(Long Id) {
		if (!postRepository.findById(Id).isEmpty()) {
			postRepository.deleteById(Id);
		} else {
			throw new NullPointerException("존재하지 않는 id값");

		}
	}
	public Optional<Post> getPost(Long id)
	{
		return postRepository.findById(id);
	}

	public void updatePost(PostForm form) {
		
	
		if (!postRepository.findById(form.getId()).isEmpty()) {
			Post post = postRepository.findById(form.getId()).get();
			post.setTitle(form.getTitle());
			post.setContents(form.getContents());
			postRepository.save(post);
		} else {
			throw new NullPointerException("존재하지 않는 id값");

		}

	}

}
