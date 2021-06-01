package edu.upc.dsa.models;

public class Usuario {

    String correo;
    String apodo;
    String nombre;
    String apellido;
    String password;
    String avatar;

    public Usuario(String correo, String apodo, String nombre, String apellido, String password, String avatar) {
        this.correo = correo;
        this.apodo = apodo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Usuario() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario(String correo, String apodo, String nombre, String apellido, String password) {
        this.correo = correo;
        this.apodo = apodo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.password = password;
    }

    public Usuario(String apodo, String password) {
        this.apodo = apodo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
