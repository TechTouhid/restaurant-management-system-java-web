package web;

import manageFood.MenuDAO;
import model.Menu;
import order.Order;
import order.OrderDAO;
import order.OrderList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/orderlist")
public class OrderListServlet extends HttpServlet {
    private OrderDAO orderDAO;

    public void init() {
        orderDAO = new OrderDAO();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderList> listOrder = OrderDAO.selectAllOrders();
        request.setAttribute("listOrder", listOrder);
        RequestDispatcher dispatcher = request.getRequestDispatcher("admin/orderlist.jsp");
        dispatcher.forward(request, response);
    }
}
