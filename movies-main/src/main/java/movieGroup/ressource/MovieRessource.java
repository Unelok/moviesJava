package movieGroup.ressource;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import movieGroup.dto.MovieDTO;
import movieGroup.model.Movie;
import movieGroup.service.MoviesEJB;

@Path("movie")
public class MovieRessource {

    @Inject
    private MoviesEJB movieEJB;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovieById(@PathParam("id") Long id) {

        return movieEJB.getMovieById(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMovies() {

        return movieEJB.getMovies();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMember(MovieDTO movie) {
        
        return movieEJB.addMovie(movie);
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteMember(@PathParam("id") Long id) {
        return movieEJB.deleteMovie(id);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMember(@PathParam("id") Long id, MovieDTO movie) {
  
        return movieEJB.updateMovie(id, movie);
    }

}
