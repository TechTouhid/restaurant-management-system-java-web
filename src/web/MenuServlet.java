package web;

import manageFood.MenuDAO;
import model.Menu;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class MenuServlet extends HttpServlet {
    private MenuDAO menuDAO;

    public void init() {
        menuDAO = new MenuDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getServletPath();

        try {
            switch (action) {
                case "/addmenu":
                    createMenu(request, response);
                    break;
                case "/listmenu":
                    listMenu(request, response);
                    break;
                case "/deletemenu":
                    deleteUser(request, response);
                    break;
                case "/editmenu":
                    menuEditForm(request, response);
                    break;
                case "/updatemenu":
                    updateUser(request, response);
                    break;
                default:
                    listMenu(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    // insert new menu in the db
    private void createMenu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        Menu newMenu = new Menu(name, price, category);
        menuDAO.insertMenu(newMenu);
        response.sendRedirect("/listmenu");
    }

    // Show all the menu
    private void listMenu(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Menu> listMenu = MenuDAO.selectAllMenus();
        request.setAttribute("listMenu", listMenu);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/food-list.jsp");
        dispatcher.forward(request, response);
    }

    // Delete menu
    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        MenuDAO.deleteMenu(id);
        response.sendRedirect("/listmenu");

    }

    // Update menu
    private void updateUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String category = request.getParameter("category");
        Menu menu = new Menu(id, name, price, category);
        MenuDAO.updateMenu(menu);
        response.sendRedirect("listmenu");
    }

    private void menuEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Menu existingUser = MenuDAO.selectMenu(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/food-edit.jsp");
        request.setAttribute("singleMenu", existingUser);
        dispatcher.forward(request, response);

    }

}
