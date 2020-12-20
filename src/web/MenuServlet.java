package web;

import manageFood.MenuDAO;
import model.Menu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "checkMenu", urlPatterns = "/addmenu")
//@WebServlet("/")
public class MenuServlet extends HttpServlet {
    private MenuDAO menuDAO;

    public void init() {
        menuDAO = new MenuDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
//        String name = request.getParameter("name");
//        double price = Double.parseDouble(request.getParameter("price"));
//        String category = request.getParameter("category");
//        System.out.println(name + price + category);
//        PrintWriter pr = response.getWriter();
//        pr.println(name + price + category);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doPost(request, response);
//        String action = request.getServletPath();
//
//        try {
//            switch (action) {
//                case "/addmenu":
//                    System.out.println(action);
//                    createMenu(request, response);
//                    break;
//            }
//        } catch (SQLException ex) {
//            throw new ServletException(ex);
//        }

        try {
            createMenu(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }


    private void createMenu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String category = request.getParameter("category");
        System.out.println("in create menu " + name + price + category);
        Menu newMenu = new Menu(name, price, category);
        menuDAO.insertMenu(newMenu);
//        response.sendRedirect("list");
        System.out.println("Done");
    }
}
