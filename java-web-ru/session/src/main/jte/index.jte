@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    @if(page.getName() != null)
        ${page.getName().toString()}
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Р’С‹Р№С‚Рё">
        </form>
    @else
        <p><a href="${NamedRoutes.buildSessionPath()}">Р’РѕР№С‚Рё</a></p>
    @endif
`)