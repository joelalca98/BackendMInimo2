package edu.upc.dsa;

import edu.upc.dsa.models.Bagde;
import edu.upc.dsa.models.Jugador;
import edu.upc.dsa.models.Usuario;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class JuegoImpl implements JuegoInterfaz {


    private static JuegoImpl manager;
    static final Logger logger = Logger.getLogger(JuegoImpl.class.getName());

    HashMap<String, Jugador> jugadores;
    List<Jugador> jugones;
    List<Usuario> usuarios;
    List<Bagde> insignias;

    private JuegoImpl() {
        /* Señalizamos las estructuras de datos */

        this.jugadores = new HashMap<String, Jugador>();
        this.jugones = new LinkedList<Jugador>();
        this.usuarios = new LinkedList<Usuario>();
        this.insignias= new LinkedList<Bagde>();

    }
    public static JuegoImpl getInstance()  /*Singletone, puerta de entrada a la instancia*/ {
        if (manager == null) manager = new JuegoImpl();
        return manager;


    }

    public static void delete() {
        manager = null;    //Permite reiniciar la base de datos
        logger.info("Instancia MathManagerImpl borrada");

    }


    @Override
    public Usuario Registro(String correo, String apodo, String nombre, String apellido, String password, String avatar) {
        Usuario usuarioNuevo = new Usuario( correo,  apodo, nombre, apellido, password, avatar);
        this.usuarios.add(usuarioNuevo);

        return usuarioNuevo;
    }
    @Override
    public Usuario Login(String apodo, String password) {
        Usuario userEcontrado = new Usuario();
        for (Usuario u : this.usuarios) {

            if (u.getNombre().equals(apodo)) {
                if (u.getPassword().equals(password)) {
                     userEcontrado = u;
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return userEcontrado;
    }

    @Override
    public List<Usuario> getAllUser() {
        return this.usuarios;
    }


    @Override
    public Usuario getUsuario(String apodo) {
        Usuario usuarioEncontrado = new Usuario();
        for (Usuario u: this.usuarios){
            if (u.getApodo().equals(apodo))
            {
                usuarioEncontrado= u;
            }
        }
        return usuarioEncontrado;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Usuario usuarioActualizado = new Usuario();
        for ( Usuario u: this.usuarios){
            if(u.getApodo().equals(usuario.getApodo()))

            {
                u.setApellido(usuario.getApellido());
                u.setNombre(usuario.getNombre());
                u.setPassword(usuario.getPassword());
                usuarioActualizado = u;
            }
        }
        return usuarioActualizado;
    }

    @Override
    public void deleteUser(String apodo) {
        for (Usuario u: this.usuarios){
            if (u.getApodo().equals(apodo)){
                this.usuarios.remove(u);
            }
        }
    }

    @Override
    public List<Jugador> muestrasJugadores(String idJugador) {
        for(Jugador j: this.jugones)
        {
            if(j.getId() == idJugador)
            {
                this.jugones.add(j);
            }
        }

        return this.jugones;
    }

    @Override
    public int sizeJugadores() {
        int ret = this.jugones.size();
        logger.info("size muestras Procesadas: "+ ret);
        return ret;
    }
    @Override
    public int sizeUser() {
        int ret = manager.usuarios.size();
        logger.info("size " + ret);

        return ret;
    }

    @Override
    public List<Bagde> getInsignias() {
        this.insignias.add(new Bagde("http://localhost:8080/img/primero.png"));
        this.insignias.add(new Bagde("http://localhost:8080/img/segundo.png"));
        this.insignias.add(new Bagde("http://localhost:8080/img/tercero.png"));
        this.insignias.add(new Bagde("http://localhost:8080/img/cuatro.png"));
        this.insignias.add(new Bagde("http://localhost:8080/img/quinto.png"));
        this.insignias.add(new Bagde("http://localhost:8080/img/sexto.png"));
        return this.insignias;
    }
}
