package edu.eci.cvds.entities;

public class Usuario {
    private String email;
    private String nombre;
    private String password;
    private int permisos;

    public Usuario(String email, String nombre, String password, int permisos) {
        this.email = email;
        this.nombre = nombre;
        this.password = password;
        this.permisos = permisos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermisos() {
        return permisos;
    }

    public void setPermisos(int permisos) {
        this.permisos = permisos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                ", permisos=" + permisos +
                '}';
    }
}
