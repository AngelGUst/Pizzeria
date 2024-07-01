package mx.edu.utez.ejercicioentidades.dao;

import mx.edu.utez.ejercicioentidades.utils.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaIngredienteDAO {
    public List<Integer> getIngredientesByPizzaId(int pizzaId) {
        List<Integer> ingredientes = new ArrayList<>();
        String query = "SELECT id_ingrediente FROM pizza_ingrediente WHERE id_pizza = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, pizzaId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ingredientes.add(rs.getInt("id_ingrediente"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredientes;
    }

    public boolean insert(int pizzaId, int ingredienteId) {
        boolean flag = false;
        String query = "INSERT INTO pizza_ingrediente (id_pizza, id_ingrediente) VALUES (?, ?)";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, pizzaId);
            ps.setInt(2, ingredienteId);
            if (ps.executeUpdate() == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete(int pizzaId, int ingredienteId) {
        boolean flag = false;
        String query = "DELETE FROM pizza_ingrediente WHERE id_pizza = ? AND id_ingrediente = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, pizzaId);
            ps.setInt(2, ingredienteId);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
