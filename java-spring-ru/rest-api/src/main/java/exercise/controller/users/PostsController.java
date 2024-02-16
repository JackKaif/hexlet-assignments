package exercise.controller.users;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private static final List<Post> posts = Data.getPosts();
    @GetMapping("/users/{id}/posts")
    public static List<Post> index(@PathVariable String id) {
        return posts.stream()
                .filter(post -> id.equals(String.valueOf(post.getUserId())))
                .toList();
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public static Post create(@PathVariable String id,
                              @RequestBody Post post) {
        post.setUserId(Integer.parseInt(id));
        posts.add(post);
        return post;
    }
}
// END
