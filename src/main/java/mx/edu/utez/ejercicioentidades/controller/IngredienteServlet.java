package mx.edu.utez.ejercicioentidades.servlet;

import mx.edu.utez.ejercicioentidades.controller.IngredienteController;
import mx.edu.utez.ejercicioentidades.model.Ingrediente;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/ingrediente")
public class IngredienteServlet extends HttpServlet {
    private IngredienteController ingredienteController;

    public void init() throws ServletException {
        try {
            ingredienteController = new IngredienteController();
        } catch (SQLException e) {
            throw new ServletException("Cannot initialize IngredienteController", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Ingrediente> ingredientes = ingredienteController.getAllIngredientes();
            request.setAttribute("ingredientes", ingredientes);
            request.getRequestDispatcher("web/ingrediente.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Cannot retrieve ingredientes", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            try {
                if (action.equals("add")) {
                    String nombre = request.getParameter("nombre");
                    int proveedor = Integer.parseInt(request.getParameter("proveedor"));
                    ingredienteController.addIngrediente(nombre, proveedor);
                } else if (action.equals("update")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    String nombre = request.getParameter("nombre");
                    int proveedor = Integer.parseInt(request.getParameter("proveedor"));
                    ingredienteController.updateIngrediente(id, nombre, proveedor);
                } else if (action.equals("delete")) {
                    int id = Integer.parseInt(request.getParameter("id"));
                    ingredienteController.deleteIngrediente(id);
                }
            } catch (SQLException e) {
                throw new ServletException("Cannot perform action on Ingrediente", e);
            }
        }
        response.sendRedirect("ingrediente");
    }
}
