package mx.edu.utez.ejercicioentidades.dao;

import mx.edu.utez.ejercicioentidades.model.Ingrediente;
import mx.edu.utez.ejercicioentidades.utils.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredienteDAO {
    public Ingrediente getOne(int id) {
        Ingrediente ingrediente = null;
        String query = "SELECT * FROM ingrediente WHERE id = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ingrediente = new Ingrediente(rs.getInt("id"), rs.getString("nombre"), rs.getInt("proveedor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingrediente;
    }

    public boolean insert(Ingrediente ingrediente) {
        boolean flag = false;
        String query = "INSERT INTO ingrediente (nombre, proveedor) VALUES (?, ?)";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ingrediente.getNombre());
            ps.setInt(2, ingrediente.getProveedor());
            if (ps.executeUpdate() == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Ingrediente> getAll() {
        List<Ingrediente> lista = new ArrayList<>();
        String query = "SELECT * FROM ingrediente";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ingrediente ingrediente = new Ingrediente(rs.getInt("id"), rs.getString("nombre"), rs.getInt("proveedor"));
                lista.add(ingrediente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean update(Ingrediente ingrediente) {
        boolean flag = false;
        String query = "UPDATE ingrediente SET nombre = ?, proveedor = ? WHERE id = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, ingrediente.getNombre());
            ps.setInt(2, ingrediente.getProveedor());
            ps.setInt(3, ingrediente.getId());
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
        String query = "DELETE FROM ingrediente WHERE id = ?";
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