package mx.edu.utez.ejercicioentidades.dao;

import mx.edu.utez.ejercicioentidades.model.Proveedor;
import mx.edu.utez.ejercicioentidades.utils.DatabaseConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    // Obtener un proveedor por ID
    public Proveedor getOne(int id) {
        Proveedor proveedor = null;
        String query = "SELECT * FROM proveedor WHERE id = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setId(rs.getInt("id"));
                proveedor.setNombre(rs.getString("nombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedor;
    }

    // Insertar un nuevo proveedor
    public boolean insert(Proveedor proveedor) {
        boolean flag = false;
        String query = "INSERT INTO proveedor (nombre) VALUES (?)";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, proveedor.getNombre());
            if (ps.executeUpdate() == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    // Obtener todos los proveedores
    public List<Proveedor> getAll() {
        List<Proveedor> lista = new ArrayList<>();
        String query = "SELECT * FROM proveedor";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId(rs.getInt("id"));
                proveedor.setNombre(rs.getString("nombre"));
                lista.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Actualizar un proveedor existente
    public boolean update(Proveedor proveedor) {
        boolean flag = false;
        String query = "UPDATE proveedor SET nombre = ? WHERE id = ?";
        try {
            Connection con = DatabaseConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, proveedor.getNombre());
            ps.setInt(2, proveedor.getId());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }

    // Eliminar un proveedor por ID
    public boolean delete(int id) {
        boolean flag = false;
        String query = "DELETE FROM proveedor WHERE id = ?";
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
