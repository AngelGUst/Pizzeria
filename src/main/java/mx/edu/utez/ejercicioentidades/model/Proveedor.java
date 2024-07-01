package mx.edu.utez.ejercicioentidades.model;

public class Proveedor {
    private int id;
    private String nombre;

    // Constructor sin parámetros
    public Proveedor() {
    }

    // Constructor con parámetros
    public Proveedor(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters
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
}

