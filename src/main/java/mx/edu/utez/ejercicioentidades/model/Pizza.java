package mx.edu.utez.ejercicioentidades.model;

import java.util.ArrayList;

public class Pizza {
    private int id;
    private String nombre;
    private double precio;
    private ArrayList<Ingrediente> listaIngredientes;

    public Pizza(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.listaIngredientes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ArrayList<Ingrediente> getListaIngredientes() {
        return listaIngredientes;
    }

    public void setListaIngredientes(ArrayList<Ingrediente> listaIngredientes) {
        this.listaIngredientes = listaIngredientes;
    }

    public void addIngrediente(Ingrediente ingrediente) {
        this.listaIngredientes.add(ingrediente);
    }
}
