package clothingstore.controller.web.profile;

import clothingstore.dao.OrderDAO;
import clothingstore.dao.OrderItemDAO;
import clothingstore.dao.UserDAO;
import clothingstore.model.OrderDTO;
import clothingstore.model.OrderItemDTO;
import clothingstore.model.UserDTO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javafx.print.Printer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "OrderedDetailsServlet", urlPatterns = {"/OrderedDetailsServlet"})
public class OrderedDetailsServlet extends HttpServlet {

    private final String PROFILE = "view/jsp/home/my-account.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        try {
            String orderID = request.getParameter("orderID");
            OrderItemDAO oDao = new OrderItemDAO();
            OrderItemDTO oItem = new OrderItemDTO();
            List<OrderItemDTO> listOrderItems = oDao.getOrderedItemByOrderID(orderID);
            PrintWriter out = response.getWriter();
            out.println("<table class=\"table table-bordered\">");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th>Product</th>");
            out.println("<th>Price</th>");
            out.println("<th>Quantity</th>");
            out.println("<th>Total</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            for (OrderItemDTO item : listOrderItems) {
                out.println("<tr>");
                out.println("<td>" + item.getOrderID() + "</td>");
                out.println("<td>" + item.getQuantity() + "</td>");
                out.println("<td>" + item.getPrice() + "</td>");
                out.println("</tr>");
            }

        } catch (Exception ex) {
            log("OrderedDetailsServlet error:" + ex.getMessage());
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        processRequest(request, response);
    }

}
