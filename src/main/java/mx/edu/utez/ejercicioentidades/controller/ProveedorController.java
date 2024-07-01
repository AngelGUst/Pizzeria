package mx.edu.utez.ejercicioentidades.controller;

import mx.edu.utez.ejercicioentidades.dao.ProveedorDAO;
import mx.edu.utez.ejercicioentidades.model.Proveedor;
import java.sql.SQLException;
import java.util.List;

public class ProveedorController {
    private ProveedorDAO proveedorDAO;

    public ProveedorController() throws SQLException {
        this.proveedorDAO = new ProveedorDAO();
    }

    public void addProveedor(String nombre) throws SQLException {
        Proveedor proveedor = new Proveedor(0, nombre);
        proveedorDAO.insert(proveedor);
    }

    public Proveedor getProveedor(int id) throws SQLException {
        return proveedorDAO.getOne(id);
    }

    public List<Proveedor> getAllProveedores() throws SQLException {
        return proveedorDAO.getAll();
    }

    public void updateProveedor(int id, String nombre) throws SQLException {
        Proveedor proveedor = new Proveedor(id, nombre);
        proveedorDAO.update(proveedor);
    }

    public void deleteProveedor(int id) throws SQLException {
        proveedorDAO.delete(id);
    }
}
