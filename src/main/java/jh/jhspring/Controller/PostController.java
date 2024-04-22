package jh.jhspring.Controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import jh.jhspring.Service.PostService;
import jh.jhspring.domain.Post;

@Controller
public class PostController {

	private final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("/")
	public String home() {
		return "index.html";
	}

	@GetMapping("create")
	public String createForm() {
		return "create.html";
	}

	@PostMapping("create")
	public String create_ok(PostForm form) {

		Post post = new Post();
		post.setTitle(form.getTitle());
		post.setContents(form.getContents());

		postService.posting(post);

		return "redirect:/";
	}

	@GetMapping("post_list")
	public String PostList(Model model) {
		List<Post> post = postService.PostList();
		model.addAttribute("posts", post);

		return "PostList.html";
	}

	@PostMapping("post_list")
	public String PostDelete_ok(PostForm form) {

		postService.deletePost(form.getId());
		return "redirect:/";
	}

	@GetMapping("post_update_form")
	public String Post_Update_Form(@RequestParam(name = "id") Long id,Model model) {
		Post post = postService.getPost(id).get();
	    model.addAttribute("post_update",post);
		return "PostUpdate.html";
	}

	@PostMapping("post_update_form")
	public String Post_Update_ok(PostForm form) {
		
		postService.updatePost(form);
		return "redirect:/";
	}

}
