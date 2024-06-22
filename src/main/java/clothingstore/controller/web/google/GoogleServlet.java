package clothingstore.controller.web.google;

import clothingstore.utils.EnvUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GoogleServlet", urlPatterns = {"/GoogleServlet"})
public class GoogleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write("{\"googleAuthUrl\": \"" + googleAuthUrl + "\"}");
        response.sendRedirect(EnvUtil.get("GOOGLE_AUTH_URL"));
    }
}
