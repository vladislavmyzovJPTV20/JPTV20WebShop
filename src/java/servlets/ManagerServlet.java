/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import entity.Category;
import entity.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.CategoryFacade;
import session.ProductFacade;

/**
 *
 * @author Влад
 */
@WebServlet(name = "ManagerServlet", urlPatterns = {
    "/addProduct",
    "/createProduct"})

public class ManagerServlet extends HttpServlet {
    @EJB private CategoryFacade categoryFacade;
    @EJB private ProductFacade productFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String path = request.getServletPath();
        switch (path) {
            case "/addProduct":
                request.setAttribute("info", "Показываем форму");
                List<Category> categories = categoryFacade.findAll();
                request.setAttribute("categories", categories);
                request.getRequestDispatcher("/WEB-INF/addProduct.jsp").forward(request, response);
                break;
            case "/createProduct":
                String productName = request.getParameter("productName");
                String price = request.getParameter("price");
                String quantity = request.getParameter("quantity");
                String[] bCategories = request.getParameterValues("categories");
                List<Category> productCategories = new ArrayList<>();
                for (int i = 0; i < bCategories.length; i++) {
                    productCategories.add(categoryFacade.find(Long.parseLong(bCategories[i])));
                }
                Product newProduct = new Product();
                newProduct.setProductname(productName);
                newProduct.setCategory(productCategories);
                newProduct.setPrice(Double.parseDouble(price));
                newProduct.setQuantity(Integer.parseInt(quantity));
                newProduct.setCount(newProduct.getQuantity());
                productFacade.create(newProduct);
                request.setAttribute("info", "Добавили продукт в базу");
                request.getRequestDispatcher("/addProduct").forward(request, response);
                break;
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
