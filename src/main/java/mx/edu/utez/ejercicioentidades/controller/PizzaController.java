package mx.edu.utez.ejercicioentidades.controller;

import mx.edu.utez.ejercicioentidades.dao.PizzaDAO;
import mx.edu.utez.ejercicioentidades.model.Pizza;

import java.sql.SQLException;
import java.util.List;

public class PizzaController {
    private PizzaDAO pizzaDAO;

    public PizzaController() throws SQLException {
        this.pizzaDAO = new PizzaDAO();
    }

    public void addPizza(String nombre, double precio) throws SQLException {
        Pizza pizza = new Pizza(0, nombre, precio);
        pizzaDAO.insert(pizza);
    }

    public Pizza getPizza(int id) throws SQLException {
        return pizzaDAO.getOne(id);
    }

    public List<Pizza> getAllPizzas() throws SQLException {
        return pizzaDAO.getAll();
    }

    public void updatePizza(int id, String nombre, double precio) throws SQLException {
        Pizza pizza = new Pizza(id, nombre, precio);
        pizzaDAO.update(pizza);
    }

    public void deletePizza(int id) throws SQLException {
        pizzaDAO.delete(id);
    }
}
