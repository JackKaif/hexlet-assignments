package exercise;

import io.javalin.Javalin;
import java.util.Comparator;
import java.util.List;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;
import java.util.Collections;
import java.util.Optional;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var userList = USERS.stream()
                    .sorted(Comparator.comparingLong(User::getId))
                    .toList();
            var usersPage = new UsersPage(userList, "Users list");
            ctx.render("users/index.jte", Collections.singletonMap("page", usersPage));
        });
        app.get("/users/{id}", ctx -> {
            var selectedUser = USERS.stream()
                    .filter(user -> ctx.pathParam("id").equals(String.valueOf(user.getId())))
                    .findFirst()
                    .orElse(null);
            Optional.ofNullable(selectedUser)
                    .map(user -> {
                        var userPage = new UserPage(user);
                        ctx.render("users/show.jte", Collections.singletonMap("page", userPage));
                        return ctx;
                    })
                    .orElseGet(() ->{
                        ctx.status(404);
                        ctx.json("Company not found");
                        return ctx;
                    });
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
