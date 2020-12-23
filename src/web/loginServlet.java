package web;

import manageFood.MenuDAO;
import model.Menu;
import model.User;
import user.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet("/adduser")
public class loginServlet extends HttpServlet {
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);

        try {
            switch (action) {
                case "/adduser":
                    createLogin(request, response);
//                    break;
//                case "/listmenu":
//                    listMenu(request, response);
//                    break;
//                case "/deletemenu":
//                    deleteUser(request, response);
//                    break;
//                case "/editmenu":
//                    menuEditForm(request, response);
//                    break;
//                case "/updatemenu":
//                    updateUser(request, response);
//                    break;
//                default:
//                    listMenu(request, response);
//                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    // insert new menu in the db
    private void createLogin(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String fullname = request.getParameter("fullname");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        System.out.println("in Create login");
        User newUser = new User(fullname, email, password);
        userDAO.insertUser(newUser);
//        response.sendRedirect("/listmenu");
    }
}
