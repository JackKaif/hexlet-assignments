@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@import gg.jte.Content
@param PostsPage page
@param Content content

@template.layout.page(
content = @`
    @if(page.getPosts().isEmpty())
        <h2>There are no posts now</h2>
    @else
        <ul>
        @for(var post : page.getPosts())
            <li><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></li>
        @endfor
        </ul>
        @if(page.getCurrentPage() > 1)
            <p><a href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() - 1}">Назад</a></p>
        @endif
        <p><a href="${NamedRoutes.postsPath()}?page=${page.getCurrentPage() + 1}">Вперёд</a></p>
    @endif
    `
)