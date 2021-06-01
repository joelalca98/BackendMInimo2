package edu.upc.dsa.models;

public class Persona {



    public String idPersona;
    public String nom;
    public int edad;
    public String apellido;
    public String estado;
    public String resultado;
    public String comentario;


    public Persona(String idPersona, String nom, int edad, String apellido, String estado) {
        this.idPersona = idPersona;
        this.nom = nom;
        this.edad = edad;
        this.apellido = apellido;
        this.estado = estado;
    }

    public Persona(){}

    public String getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(String idPersona) {
        this.idPersona = idPersona;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
