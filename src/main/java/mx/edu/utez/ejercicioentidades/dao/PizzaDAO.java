package mx.edu.utez.ejercicioentidades.dao;

import mx.edu.utez.ejercicioentidades.model.Pizza;
import mx.edu.utez.ejercicioentidades.utils.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PizzaDAO {
    public Pizza getOne(int id) {
        Pizza pizza = null;
        String query = "SELECT * FROM pizza WHERE id = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pizza = new Pizza(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pizza;
    }

    public boolean insert(Pizza pizza) {
        boolean flag = false;
        String query = "INSERT INTO pizza (nombre, precio) VALUES (?, ?)";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pizza.getNombre());
            ps.setDouble(2, pizza.getPrecio());
            if (ps.executeUpdate() == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Pizza> getAll() {
        List<Pizza> lista = new ArrayList<>();
        String query = "SELECT * FROM pizza";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pizza pizza = new Pizza(rs.getInt("id"), rs.getString("nombre"), rs.getDouble("precio"));
                lista.add(pizza);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean update(Pizza pizza) {
        boolean flag = false;
        String query = "UPDATE pizza SET nombre = ?, precio = ? WHERE id = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, pizza.getNombre());
            ps.setDouble(2, pizza.getPrecio());
            ps.setInt(3, pizza.getId());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean delete(int id) {
        boolean flag = false;
        String query = "DELETE FROM pizza WHERE id = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
