@import exercise.dto.users.UserPage
@param UserPage page

<!-- Изменения HTML в шаблоне не требуют перезапуска сервера -->
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>ID: ${page.getUser().getId()}</title>
    </head>
    <body>
        <div class="col-lg-8 mx-auto p-4 py-md-5">
            <main>
                <h1>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</h1>
                <p>${page.getUser().getEmail()}</p>
            </main>
        </div>
    </body>
</html>