package exercise.controller;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import static java.util.Optional.ofNullable;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        var currentPage = Integer.parseInt(ofNullable(ctx.queryParam("page")).
                orElse("1"));
        var posts = new ArrayList<Post>();
        var postsPerPage = 5;
        for (var i = (currentPage - 1) * postsPerPage;
             i < currentPage * postsPerPage && i < PostRepository.getEntities().size();
             i++) {
            posts.add(PostRepository.getEntities().get(i));
        }
        var page = new PostsPage(posts, currentPage);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));
    }

    public static void show(Context ctx) {
        var id = Long.valueOf(ctx.pathParam("id"));
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    // END
}
