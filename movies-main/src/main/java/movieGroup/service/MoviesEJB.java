package movieGroup.service;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

import movieGroup.converter.MovieConverter;
import movieGroup.dao.MovieDao;
import movieGroup.dto.MovieDTO;
import movieGroup.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class MoviesEJB {
    @Inject
    private MovieDao movieDao;

    @Inject
    private MovieConverter movieConverter;


    public Response getMovieById(Long id) {
        if (id == null || id == 0) {
            return Response.status(403).build();
        }
        Movie resultDatabase = movieDao.getMovieById(id);
        MovieDTO resultMovieDTO = movieConverter.toDTO(resultDatabase);
        return Response.ok(resultMovieDTO).build();
    }

    public Response getMovies() {
        List<Movie> movieList = movieDao.getMovies();
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for (Movie movie : movieList) {
            MovieDTO movieDTO = movieConverter.toDTO(movie);
            movieDTOList.add(movieDTO);
        }
        return Response.ok(movieDTOList).build();
    }

    public Response addMovie(MovieDTO movie) {
        if (movie.getYear() == null || movie.getName() == null || movie.getDuration() == null || movie.getDirector() == null) {
            return Response.status(403).build();
        }
        Movie entityMovie = movieConverter.toMovie(movie);
        boolean result = movieDao.addMovie(entityMovie);
        return Response.ok(Boolean.toString(result)).build();
    }

    public Response deleteMovie(Long id) {
        if (id == null || id == 0) {
            return Response.status(403).build();
        }
        boolean result = movieDao.deleteMovieById(id);
        return Response.ok(Boolean.toString(result)).build();
    }

    public Response updateMovie(Long id, MovieDTO movie) {
        if (id == null || id == 0) {
            return Response.status(403).build();
        }
        if (movie.getDirector() == null || movie.getName() == null){
            return Response.status(403).build();
        }
        Movie entityMovie = movieDao.getMovieById(id);
        entityMovie.setDirector(movie.getDirector());
        entityMovie.setName(movie.getName());
        boolean result = movieDao.updateMovieMember(entityMovie);
        return Response.ok(Boolean.toString(result)).build();

    }
}
