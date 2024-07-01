package mx.edu.utez.ejercicioentidades.controller;

import mx.edu.utez.ejercicioentidades.controller.ProveedorController;
import mx.edu.utez.ejercicioentidades.model.Proveedor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/proveedor")
public class ProveedorServlet extends HttpServlet {
    private ProveedorController proveedorController;

    public ProveedorServlet() {
        try {
            this.proveedorController = new ProveedorController();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        try {
            proveedorController.addProveedor(nombre);
            response.sendRedirect("proveedor");
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Proveedor> proveedores = proveedorController.getAllProveedores();
            request.setAttribute("proveedores", proveedores);
            request.getRequestDispatcher("proveedor.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}