package edu.upc.dsa.models;

public class Jugador {

    String idJugador;
    String apodo;
    Integer nivel;
    String contraseña;

    public Jugador() {
    }

    public Jugador(String idJugador, String apodo, Integer nivel, String contraseña) {
        this.idJugador = idJugador;
        this.apodo = apodo;
        this.nivel = nivel;
        this.contraseña = contraseña;
    }

    public String getId() {
        return idJugador;
    }

    public void setId(String id) {
        this.idJugador = id;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }


    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
