@import gg.jte.Content
@param Content content
@param Content footer = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <title>Javalin Example</title>
    </head>
    <body>
        <main>
            <h1><a href="/">Main page</a></h1>
            <h1><a href="/users">Users</a></h1>
            ${content}
            @if(footer == null)
                <p>I'm footer!</p>
            @endif
        </main>
    </body>
</html>