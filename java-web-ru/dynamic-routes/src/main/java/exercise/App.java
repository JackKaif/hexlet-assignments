package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.Map;
import static java.util.Optional.ofNullable;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var result = COMPANIES.stream()
                    .filter(map -> ctx.pathParam("id").equals(map.get("id")))
                    .findFirst()
                    .orElse(null);
            ofNullable(result)
                    .map(ctx::json)
                    .orElseGet(() -> {
                        ctx.status(404);
                        ctx.json("Company not found");
                        return ctx;
                    });
        });
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
