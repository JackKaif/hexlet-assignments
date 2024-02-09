package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            var pageParam = ctx.queryParam("page");
            var page = pageParam != null ?
                    Integer.parseInt(pageParam) :
                    1;
            var perParam = ctx.queryParam("per");
            var per = perParam != null ?
                    Integer.parseInt(perParam) :
                    5;
            var result = IntStream.range((page - 1) * per, page * per)
                    .mapToObj(USERS::get)
                    .collect(Collectors.toCollection(ArrayList::new));
            ctx.json(result);
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
