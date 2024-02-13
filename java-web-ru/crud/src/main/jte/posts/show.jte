@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@import gg.jte.Content
@param PostPage page
@param Content content

@template.layout.page(
    content = @`
        <h2>${page.getPost().getName()}</h2>
        <p>${page.getPost().getBody()}</p>
        <p><a href="${NamedRoutes.postsPath()}">Назад</a></p>
    `
)
