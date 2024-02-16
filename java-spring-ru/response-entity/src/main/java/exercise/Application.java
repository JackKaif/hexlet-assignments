package exercise;

import java.net.URI;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import exercise.model.Post;

@SpringBootApplication
@RestController
public class Application {
    // Хранилище добавленных постов
    private List<Post> posts = Data.getPosts();

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @GetMapping("/posts")
    public ResponseEntity<List<Post>> index() {
        return ResponseEntity.ok()
                .header("X-Total-Count", String.valueOf(posts.size()))
                .body(posts);
    }

    @GetMapping("/posts/{id}")
    public ResponseEntity<?> show(@PathVariable String id) {
        var searchedPost = posts.stream()
                .filter(post -> id.equals(post.getId()))
                .findFirst();
        if (searchedPost.isPresent()) {
            return ResponseEntity.of(searchedPost);
        } else {
            return ResponseEntity.status(404)
                    .body(id);
        }
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> create(@RequestBody Post post) {
        posts.add(post);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(post);
    }

    @PutMapping("/posts/{id}")
    public ResponseEntity<?> update(@RequestBody Post updatedPost,
                                    @PathVariable String id) {
        var searchedPost = posts.stream()
                .filter(post -> id.equals(post.getId()))
                .findFirst();
        if (searchedPost.isPresent()) {
            var editedPost = searchedPost.get();
            editedPost.setTitle(updatedPost.getTitle());
            editedPost.setBody(updatedPost.getBody());
            posts.add(editedPost);
            return ResponseEntity.ok(editedPost);
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(updatedPost);
        }
    }
    // END

    @DeleteMapping("/posts/{id}")
    public void destroy(@PathVariable String id) {
        posts.removeIf(p -> p.getId().equals(id));
    }
}
