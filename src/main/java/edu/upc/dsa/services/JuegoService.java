package edu.upc.dsa.services;


import edu.upc.dsa.JuegoImpl;
import edu.upc.dsa.JuegoInterfaz;
import edu.upc.dsa.models.Bagde;
import edu.upc.dsa.models.Usuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Api(value = "/user", description = "Endpoint to Track Service")
@Path("/user")
public class JuegoService {

    private JuegoInterfaz jm;

    public JuegoService() {
        this.jm = JuegoImpl.getInstance();
        if(jm.sizeUser()==0){
            this.jm.Registro("carlo@upc.edu","Pachm","Joel","Alcalde","1234","http://localhost:8080/img/primero.png");
            this.jm.Registro("victor@upc.edu","Victorioso","Victor","Gutierrez","678","http://localhost:8080/img/segundo.png");
            this.jm.Registro("toni@upc.edu","ToniMontana","Toni","Montana","456","http://localhost:8080/img/tercero.png");

        }
    }
    //Obtener un usuario
    @GET
    @ApiOperation(value = "get a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Usuario.class),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{apodo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("apodo") String apodo) {
        Usuario u = this.jm.getUsuario(apodo);
        if (u == null) return Response.status(404).build();
        else  return Response.status(201).entity(u).build();
        //Track t = this.tm.getTrack(id);
    }

    //Crear un usuario
    @POST
    @ApiOperation(value = "create a new User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newUser(Usuario usuario) {

        if (usuario.getCorreo()==null || usuario.getPassword()==null || usuario.getApodo()==null )  return Response.status(500).entity(usuario).build();
        this.jm.Registro(usuario.getCorreo(), usuario.getApodo(), usuario.getNombre(), usuario.getApellido(), usuario.getPassword(), usuario.getAvatar());

        return Response.status(201).entity(usuario).build();
    }


    //RUTA MINIMO 2

    @GET
    @ApiOperation(value = "get all Insignias", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Bagde.class, responseContainer="List"),
    })
    @Path("/badges")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getInsignias() {

        List<Bagde> insignias = this.jm.getInsignias();

        GenericEntity<List<Bagde>> entity = new GenericEntity<List<Bagde>>(insignias) {};
        return Response.status(201).entity(entity).build()  ;

    }








    //Actualizar un usuario
    @PUT
    @ApiOperation(value = "update a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/")
    public Response updateUser(Usuario usuario) {

        Usuario u = this.jm.actualizarUsuario(usuario);

        if (u == null) return Response.status(404).build();

        return Response.status(201).build();
    }
    //Eliminar un usuario
    @DELETE
    @ApiOperation(value = "delete a User", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "User not found")
    })
    @Path("/{apodo}")
    public Response deleteUser(@PathParam("apodo") String apodo) {
        Usuario t = this.jm.getUsuario(apodo);
        if (t == null) return Response.status(404).build();
        else this.jm.deleteUser(apodo);
        return Response.status(201).build();
    }
    //Login
    @POST
    @ApiOperation(value = "Login", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Usuario.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Usuario usu) {

        Usuario u = this.jm.getUsuario(usu.getApodo());
        if (usu.getApodo() == null || usu.getPassword() == null){
            return Response.status(404).build();

        }
        else if(usu.getPassword().equals(u.getPassword())  ){
            return Response.status(201).entity(u).build();
        }
        else{
            return null;
        }

    }
    /*@GET
    @ApiOperation(value = "get all Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class, responseContainer="List"),
    })
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTracks() {

        List<Track> tracks = this.tm.findAll();

        GenericEntity<List<Track>> entity = new GenericEntity<List<Track>>(tracks) {};
        return Response.status(201).entity(entity).build()  ;

    }

    @GET
    @ApiOperation(value = "get a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response = Track.class),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTrack(@PathParam("id") String id) {
        Track t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else  return Response.status(201).entity(t).build();
    }

    @DELETE
    @ApiOperation(value = "delete a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/{id}")
    public Response deleteTrack(@PathParam("id") String id) {
        Track t = this.tm.getTrack(id);
        if (t == null) return Response.status(404).build();
        else this.tm.deleteTrack(id);
        return Response.status(201).build();
    }

    @PUT
    @ApiOperation(value = "update a Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful"),
            @ApiResponse(code = 404, message = "Track not found")
    })
    @Path("/")
    public Response updateTrack(Track track) {

        Track t = this.tm.updateTrack(track);

        if (t == null) return Response.status(404).build();

        return Response.status(201).build();
    }



    @POST
    @ApiOperation(value = "create a new Track", notes = "asdasd")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful", response=Track.class),
            @ApiResponse(code = 500, message = "Validation Error")

    })

    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newTrack(Track track) {

        if (track.getSinger()==null || track.getTitle()==null)  return Response.status(500).entity(track).build();
        this.tm.addTrack(track);
        return Response.status(201).entity(track).build();
    }*/

}