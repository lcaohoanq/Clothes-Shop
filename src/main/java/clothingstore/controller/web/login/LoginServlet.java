package clothingstore.controller.web.login;

import clothingstore.impl.UserServiceImpl;
import clothingstore.model.UserGoogleDTO;
import clothingstore.constant.GoogleAuthentication;
import clothingstore.utils.PBKDF2;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import clothingstore.model.UserDTO;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Form;

@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {

    private final String WELCOME = "MainController";
    private final String LOGIN = "view/jsp/home/login.jsp";
    private final String ADMIN_DASHBOARD = "AdminServlet";
    private final String REGISTER_CONTROLLER = "RegisterServlet";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String code = request.getParameter("code");
        String error = request.getParameter("error");
        // neu nguoi dung huy uy quyen
        if (error != null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        LoginGoogle gg = new LoginGoogle();
        String accessToken = LoginGoogle.getToken(code);
        System.out.println("access_token: " + accessToken);
        UserGoogleDTO acc = LoginGoogle.getUserInfo(accessToken);
        System.out.println("Data user: " + acc);
    }

    public static String getToken(String code) throws IOException {
        // call api to get token
        String response = Request.Post(GoogleAuthentication.GOOGLE_LINK_GET_TOKEN)
                .bodyForm(Form.form().add("client_id", GoogleAuthentication.GOOGLE_CLIENT_ID)
                        .add("client_secret", GoogleAuthentication.GOOGLE_CLIENT_SECRET)
                        .add("redirect_uri", GoogleAuthentication.GOOGLE_REDIRECT_URI).add("code", code)
                        .add("grant_type", GoogleAuthentication.GOOGLE_GRANT_TYPE).build())
                .execute().returnContent().asString();

        JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
        String accessToken = jobj.get("access_token").toString().replaceAll("\"", "");
        return accessToken;
    }

    public static UserGoogleDTO getUserInfo(final String accessToken)
            throws IOException {
        String link = GoogleAuthentication.GOOGLE_LINK_GET_USER_INFO + accessToken;
        String response = Request.Get(link).execute().returnContent().asString();

        UserGoogleDTO googlePojo = new Gson().fromJson(response, UserGoogleDTO.class);

        return googlePojo;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // +
    // sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String url = WELCOME;
        try {
            request.setAttribute("CURRENTSERVLET", "Login");
            if (request.getParameter("btnAction") != null) {
                Cookie[] arr = request.getCookies();
                if (arr != null) {
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i].getName().equals("cUName")) {
                            request.setAttribute("uName", arr[i].getValue());
                        }
                        if (arr[i].getName().equals("cUPass")) {
                            request.setAttribute("uPass", arr[i].getValue());
                        }
                        if (arr[i].getName().equals("reMem")) {
                            request.setAttribute("reMem", arr[i].getValue());
                        }
                    }
                }
                url = LOGIN;
            } else {
                String code = request.getParameter("code");
                String accessToken = getToken(code);
                UserGoogleDTO userGG = getUserInfo(accessToken);
                if (userGG != null) {
                    UserServiceImpl userService = new UserServiceImpl();
                    UserDTO account = userService.getUserByEmail(userGG.getEmail());
                    if (account != null) {
                        HttpSession session = request.getSession();
                        session.setAttribute("account", account);
                        if (account.getRoleID() == 1) {
                            response.sendRedirect(ADMIN_DASHBOARD);
                        } else {
                            response.sendRedirect(WELCOME);
                        }
                    } else {
                        String error = "You need register your account!";
                        request.setAttribute("msgRegisterGG", error);
                        request.setAttribute("emailGG", userGG.getEmail());
                        request.setAttribute("firstNameGoogleAccount", userGG.getGiven_name());
                        request.setAttribute("lastNameGoogleAccount", userGG.getFamily_name());
                        request.setAttribute("avatar", userGG.getPicture());
                        url = REGISTER_CONTROLLER;
                    }
                }
            }
        } catch (Exception ex) {
            log("LoginServlet error:" + ex.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String url = WELCOME;
        ResultSet rs = null;
        try {
            String btnValue = request.getParameter("btnAction");
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String remember = request.getParameter("remember");
            UserServiceImpl userService = new UserServiceImpl();
            String hashedPassword = new UserServiceImpl().getUserByUsername(username).getPassword();
            if (password.equals(hashedPassword) || new PBKDF2().authenticate(password.toCharArray(), hashedPassword)) {
                UserDTO user = userService.checkLogin(username, hashedPassword);
                HttpSession session = request.getSession();
                session.setAttribute("account", user);
                Cookie u = new Cookie("cUName", username);
                Cookie p = new Cookie("cUPass", hashedPassword);
                Cookie r = new Cookie("reMem", remember);

                u.setMaxAge(60 * 60 * 24 * 30 * 3); // 3months
                if (remember != null) {
                    p.setMaxAge(60 * 60 * 24 * 30 * 3);
                    r.setMaxAge(60 * 60 * 24 * 30 * 3);
                } else {
                    p.setMaxAge(0);
                    r.setMaxAge(0);
                }

                response.addCookie(u);
                response.addCookie(p);
                response.addCookie(r);
                if (user.getRoleID() == 1) {
                    response.sendRedirect(ADMIN_DASHBOARD);
                } else {
                    response.sendRedirect(WELCOME);
                }
            } else {
                String error = "Invalid username or password!";
                request.setAttribute("msg", error);
                RequestDispatcher rd = request.getRequestDispatcher(LOGIN);
                rd.forward(request, response);
            }
        } catch (Exception ex) {
            log("LoginServlet error:" + ex.getMessage());
        } finally {
            out.close();
        }
    }

}
