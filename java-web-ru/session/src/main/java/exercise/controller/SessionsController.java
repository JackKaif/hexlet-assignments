package exercise.controller;

import java.util.Collections;
import exercise.dto.LoginPage;
import exercise.model.User;


import exercise.util.Generator;
import exercise.util.NamedRoutes;
import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.validation.ValidationException;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        var page = new LoginPage("", null);
        ctx.render("build.jte", Collections.singletonMap("page", page));
    }

    public static void create(Context ctx) {
        try {
            var nickname = ctx.formParamAsClass("name", String.class)
                    .check(value -> Generator.getUsers().stream()
                            .map(User::getName)
                            .anyMatch(value::equals), "Wrong username or password")
                    .get();
            var user = Generator.getUsers().stream()
                    .filter(us -> us.getName().equals(nickname))
                    .findAny()
                    .get();
            ctx.formParamAsClass("password", String.class)
                    .check(value -> user.getPassword().equals(Security.encrypt(value)), "Wrong username or password")
                    .get();
            ctx.sessionAttribute("currentUser", nickname);
            ctx.redirect(NamedRoutes.rootPath());
        } catch (ValidationException e) {
            var page = new LoginPage(ctx.formParam("name"), e.getErrors());
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }
    // END
}
