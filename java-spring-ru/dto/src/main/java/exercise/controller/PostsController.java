package exercise.controller;

import exercise.model.Comment;
import exercise.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

import exercise.model.Post;
import exercise.repository.PostRepository;
import exercise.exception.ResourceNotFoundException;
import exercise.dto.PostDTO;
import exercise.dto.CommentDTO;

// BEGIN
@RestController
@RequestMapping("/posts")
public class PostsController {
    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("")
    public List<PostDTO> index() {
        var posts = postRepository.findAll();
        return posts.stream()
                .map(this::postToDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public PostDTO show(@PathVariable Long id) {
        var result = postRepository.findById(id)
                .orElseThrow(() -> {
                    throw new ResourceNotFoundException(
                            String.format("Post with id %d not found", id)
                    );
                });
        return postToDTO(result);
    }

    private PostDTO postToDTO(Post post) {
        var result = new PostDTO();
        result.setId(post.getId());
        result.setTitle(post.getTitle());
        result.setBody(post.getBody());
        var comments = commentRepository.findByPostId(post.getId()).stream()
                .map(this::commentToDTO)
                .toList();
        result.setComments(comments);
        return result;
    }

    private CommentDTO commentToDTO(Comment comment) {
        var result = new CommentDTO();
        result.setId(comment.getId());
        result.setBody(comment.getBody());
        return result;
    }
}
// END
