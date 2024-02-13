@import exercise.util.NamedRoutes
@import exercise.dto.LoginPage
@param LoginPage page

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
    <form action="${NamedRoutes.loginPath()}" method="post">
        <input type="text" placeholder="Nickname" name="name" value="${page.getName()}"/>
        <input type="password" placeholder="Password" name="password" />
        <input type="submit" />
    </form>
`
)