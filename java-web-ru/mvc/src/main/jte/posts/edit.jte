@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@import gg.jte.Content
@param PostPage page
@param Content content

@template.layout.page(
content = @`
    <form action="${NamedRoutes.postPath(page.getPost().getId())}" method="post">
        <input type="hidden" name="_method" value="PATCH">
        <div class="mb-3">
            <label class="form-label">
                Название
                <input type="text" class="form-control" name="name" value="${page.getPost().getName()}" />
            </label>
        </div>
        <div class="mb-3">
            <label class="form-label">Содержание</label>
            <textarea class="form-control" rows="20" cols="70" type="text" name="body">${page.getPost().getBody()}</textarea>
        </div>
        <input type="submit" class="btn btn-primary" value="Сохранить" />
    </form>
`
)