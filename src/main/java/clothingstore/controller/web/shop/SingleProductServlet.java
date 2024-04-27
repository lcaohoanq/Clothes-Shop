package clothingstore.controller.web.shop;

import clothingstore.dao.ProductDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import clothingstore.model.ProductDTO;

@WebServlet(name = "SingleProductServlet", urlPatterns = {"/SingleProductServlet"})
public class SingleProductServlet extends HttpServlet {
    
    private static final String SINGLE_PRODUCT_PAGE ="view/jsp/home/single-product.jsp";
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = SINGLE_PRODUCT_PAGE;
        try {
            
            ProductDAO pDao = new ProductDAO();
            String product_id = request.getParameter("product_id");
            ProductDTO product = pDao.getProductByID(Integer.parseInt(product_id));
            List<ProductDTO> listProduct = pDao.getProductByCategoryId(pDao.getData(), product.getCategory().getId());
            List<ProductDTO> listSameCategory = new ArrayList<>();
            int count = 0;
            for (ProductDTO productDTO : listProduct) {
                if(productDTO.getId() != product.getId()){
                    listSameCategory.add(productDTO);
                    count++;
                    if(count == 4) {
                        break;
                    }
                }
            }
            
            request.setAttribute("PRODUCT", product);
            request.setAttribute("LIST_PRODUCTS_SAME_CATEGORY", listSameCategory);
            
        } catch (Exception ex) {
            log("SingleProductServlet error:" + ex.getMessage());
        }finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
