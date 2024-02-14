@import exercise.util.NamedRoutes
@import exercise.dto.BasePage
@import gg.jte.Content
@param Content content
@param BasePage page = null

<!doctype html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport"
              content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Document</title>
    </head>
    <body>
        <h1><a href="/"> Main page</a></h1>
        <h1><a href="${NamedRoutes.postsPath()}">Posts list</a></h1>
        ${content}
        @if(page != null && page.getFlashMessage() != null)
            <p>${page.getFlashMessage()}</p>
        @endif
    </body>
</html>