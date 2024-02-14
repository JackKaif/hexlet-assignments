package exercise.servlet;

import java.io.IOException;
import java.util.Objects;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN
    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        var sb = new StringBuilder("Hello, ");
        var name = request.getParameter("name");
        sb.append(Objects.requireNonNullElse(name, " Guest"));
        sb.append("!");
        request.setAttribute("message", sb.toString());
        request.getRequestDispatcher("WEB-INF/hello.jsp").forward(request, response);
    }
    // END
}
