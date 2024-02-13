@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    @if(page.getName() != null)
        ${page.getName().toString()}
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти">
        </form>
    @else
        <p><a href="${NamedRoutes.buildSessionPath()}">Войти</a></p>
    @endif
`)