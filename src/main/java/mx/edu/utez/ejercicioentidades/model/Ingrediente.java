package mx.edu.utez.ejercicioentidades.model;

public class Ingrediente {
    private int id;
    private String nombre;
    private int proveedor;

    public Ingrediente(int id, String nombre, int proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.proveedor = proveedor;
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

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor= proveedor;
    }
}

