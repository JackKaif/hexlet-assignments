@import exercise.dto.users.UsersPage
@param UsersPage page

<!-- Изменения HTML в шаблоне не требуют перезапуска сервера -->
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>${page.getHeader()}</title>
    </head>
    <body>
        <div class="col-lg-8 mx-auto p-4 py-md-5">
            <main>
                <h1>${page.getHeader()}</h1>
                @if(page.getUsers().isEmpty())
                    <p>No users right now.</p>
                @else
                    @for(var user : page.getUsers())
                        <div>
                            <h2><a href="/users/${user.getId()}">ID: ${user.getId()}. ${user.getFirstName()} ${user.getLastName()}</a></h2>
                        </div>
                    @endfor
                @endif
            </main>
        </div>
    </body>
</html>