package web;

import model.User;
import order.Order;
import order.OrderDAO;
import order.OrderList;
import user.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addorder")
public class OrderServlet extends HttpServlet {
    private OrderDAO orderDAO;

    public void init() {
        orderDAO = new OrderDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int menuId = Integer.parseInt(request.getParameter("id"));
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String foodName = request.getParameter("foodName");
        String category = request.getParameter("category");
        String price = request.getParameter("price");
        OrderList newOrder = new OrderList(menuId, foodName, price, category, email);
        try {
            orderDAO.insertOrder(newOrder);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String info = "Thank You " + username + " Your Order Successfully Placed";
        request.setAttribute("outputMessage", info);
        request.getRequestDispatcher("orderConformation.jsp").forward(request,response);
    }
}
