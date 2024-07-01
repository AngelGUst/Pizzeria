package mx.edu.utez.ejercicioentidades.servlet;

import mx.edu.utez.ejercicioentidades.controller.PizzaController;
import mx.edu.utez.ejercicioentidades.model.Pizza;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/pizza")
public class PizzaServlet extends HttpServlet {
    private PizzaController pizzaController;

    public void init() throws ServletException {
        try {
            pizzaController = new PizzaController();
        } catch (SQLException e) {
            throw new ServletException("Cannot initialize PizzaController", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Pizza> pizzas = pizzaController.getAllPizzas();
            request.setAttribute("pizzas", pizzas);
            request.getRequestDispatcher("web/pizza.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Cannot retrieve pizzas", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            try {
                if (action.equals("add")) {
                    String nombre = request.getParameter("nombre");
                    double precio = Double.parseDouble(request.getParameter("precio"));
                    pizzaController.addPizza(nombre, precio);
                } else if (action.equals("update")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String nombre = request.getParameter("nombre");
                    double precio = Double.parseDouble(request.getParameter("precio"));
                    pizzaController.updatePizza(id, nombre, precio);
                } else if (action.equals("delete")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    pizzaController.deletePizza(id);
                }
            } catch (SQLException e) {
                throw new ServletException("Cannot perform action on Pizza", e);
            }
        }
        response.sendRedirect("pizza");
    }
}
