@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@import gg.jte.Content
@param Content content
@param PostsPage page

@template.layout.page(
    page = page,
    content = @`
        <h2>Posts list</h2>
        @if(page.getPosts().isEmpty())
            <p>No posts</p>
        @else
            <ul>
                @for(var post : page.getPosts())
                    <li><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></li>
                @endfor
            </ul>
        @endif
        <p><a href="${NamedRoutes.buildPostPath()}">Add new post</a></p>
    `
)
