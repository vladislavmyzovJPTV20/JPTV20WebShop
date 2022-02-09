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
    "/index",
    "/listProducts",
    "/addProduct", 
    "/createProduct",
    "/editListProducts",
    "/editProduct",
    "/updateProduct",
    "/addCategory",
    "/createCategory"
})
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
            case "/index":
                request.getRequestDispatcher("/listProducts").forward(request, response);
                break;
            case "/listProducts":
                request.setAttribute("info", "Показываем форму");
                List<Product> products = productFacade.findAll();
                request.setAttribute("products", products);
                request.getRequestDispatcher("/listProducts.jsp").forward(request, response);
                break;
            case "/addProduct":
                request.setAttribute("info", "Показываем форму");
                List<Category> categories = categoryFacade.findAll();
                request.setAttribute("categories", categories);
                request.setAttribute("activeAddProduct", true);
                request.getRequestDispatcher("/WEB-INF/addProduct.jsp").forward(request, response);
                break;
            case "/createProduct":
                String productname = request.getParameter("productname");
                String price = request.getParameter("price");
                String quantity = request.getParameter("quantity");
                String[] productCategoriesArray = request.getParameterValues("categories");
                List<Category> productCategories = new ArrayList<>();
                for (int i = 0; i < productCategoriesArray.length; i++) {
                    productCategories.add(categoryFacade.find(Long.parseLong(productCategoriesArray[i])));
                }
                Product newProduct = new Product();
                newProduct.setProductname(productname);
                newProduct.setCategory(productCategories);
                newProduct.setPrice(Double.parseDouble(price));
                newProduct.setQuantity(Integer.parseInt(quantity));
                newProduct.setCount(newProduct.getQuantity());
                try {
                    productFacade.create(newProduct);
                    request.setAttribute("info", "Успешно добавили продукт в базу");
                } catch (Exception e) {
                    request.setAttribute("info", "Добавить продукт не удалось");
                }
                request.getRequestDispatcher("/addProduct").forward(request, response);
                break;
            case "/editListProducts":
                request.setAttribute("activeEditListProducts", true);
                List<Product>listProducts = productFacade.findAll();
                request.setAttribute("products", listProducts);
                request.getRequestDispatcher("/WEB-INF/editListProducts.jsp").forward(request, response);
                break;
            case "/editProduct":
                request.setAttribute("activeEditListProducts", true);
                String productId = request.getParameter("productId");
                Product product = productFacade.find(Long.parseLong(productId));
                request.setAttribute("product", product);
                request.getRequestDispatcher("/WEB-INF/editProduct.jsp").forward(request, response);
                break;
            case "/updateProduct":
                productId = request.getParameter("productId");
                productname = request.getParameter("productname");
                categories = new ArrayList<>();
                String[] newProductCategoriesArray = request.getParameterValues("categories");
                for (int i = 0; i < newProductCategoriesArray.length; i++) {
                    categories.add(categoryFacade.find(Long.parseLong(newProductCategoriesArray[i])));
                }
                price = request.getParameter("price");
                quantity = request.getParameter("quantity");
                Product updateProduct = productFacade.find(Long.parseLong(productId));
                updateProduct.setProductname(productname);
                updateProduct.setQuantity(Integer.parseInt(quantity));
                updateProduct.setPrice(Double.parseDouble(price));
                updateProduct.setCategory(categories);
                productFacade.edit(updateProduct);
                request.setAttribute("info", "Продукт изменен");
                request.getRequestDispatcher("/editListProducts").forward(request, response);
                break;
            case "/addCategory":
                request.setAttribute("activeAddCategory", true);
                request.getRequestDispatcher("/WEB-INF/addCategory.jsp").forward(request, response);
                break;
            case "/createCategory":
                String CategoryName = request.getParameter("CategoryName");
                Category category = new Category();
                category.setCategoryName(CategoryName);
                categoryFacade.create(category);
                request.setAttribute("info", "Категория успешно добавлена");
                request.getRequestDispatcher("/addCategory").forward(request, response);
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
