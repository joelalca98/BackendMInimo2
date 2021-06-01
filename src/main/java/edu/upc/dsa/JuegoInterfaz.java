package edu.upc.dsa;

import edu.upc.dsa.models.Bagde;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Usuario;

import java.util.List;

public interface JuegoInterfaz {
    //autenticacion
    public Usuario Registro (String correo, String apodo, String nombre, String apellido, String password, String avatar);
    public Usuario Login (String user, String password);


    //servicios  (A implementar lo mas prontro)
    public List<Usuario> getAllUser ();
    public Usuario getUsuario (String id);
    public Usuario actualizarUsuario( Usuario usuario) ;
    public void deleteUser(String id);

    public List<Jugador> muestrasJugadores (String idJugador);
    public int sizeJugadores();
    public int sizeUser();



    //minimo2
    public List<Bagde> getInsignias();



}
