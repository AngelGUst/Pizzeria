package mx.edu.utez.ejercicioentidades.controller;

import mx.edu.utez.ejercicioentidades.dao.IngredienteDAO;
import mx.edu.utez.ejercicioentidades.model.Ingrediente;

import java.sql.SQLException;
import java.util.List;

public class IngredienteController {
    private IngredienteDAO ingredienteDAO;

    public IngredienteController() throws SQLException {
        this.ingredienteDAO = new IngredienteDAO();
    }

    public void addIngrediente(String nombre, int proveedor) throws SQLException {
        Ingrediente ingrediente = new Ingrediente(0, nombre, proveedor);
        ingredienteDAO.insert(ingrediente);
    }

    public Ingrediente getIngrediente(int id) throws SQLException {
        return ingredienteDAO.getOne(id);
    }

    public List<Ingrediente> getAllIngredientes() throws SQLException {
        return ingredienteDAO.getAll();
    }

    public void updateIngrediente(int id, String nombre, int proveedor) throws SQLException {
        Ingrediente ingrediente = new Ingrediente(id, nombre, proveedor);
        ingredienteDAO.update(ingrediente);
    }

    public void deleteIngrediente(int id) throws SQLException {
        ingredienteDAO.delete(id);
    }
}
