@import exercise.dto.articles.BuildArticlePage
@import gg.jte.Content
@param BuildArticlePage page
@param Content content

@template.layout.page(
    content = @`
    @if(page.getErrors() != null)
        <ul>
            @for(var validator : page.getErrors().values())
                @for(var error : validator)
                    <li>${error.getMessage()}</li>
                @endfor
            @endfor
        </ul>
    @endif
    <form action="/articles" method="post">
        <div>
            <label>
                Название
                <input type="text" required name="title" value="${page.getTitle()}"/>
            </label>
        </div>
        <div>
            <label>
                Текст
                <input type="text" required name="content" value="${page.getContent()}"/>
            </label>
        </div>
        <input type="submit" value="Добавить" />
    </form>
    `
)
