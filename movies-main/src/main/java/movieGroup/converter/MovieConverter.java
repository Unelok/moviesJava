package movieGroup.converter;

import movieGroup.dto.MovieDTO;
import movieGroup.model.Movie;

public class MovieConverter {
    public MovieDTO toDTO(Movie movie){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setDuration(movie.getDuration());
        movieDTO.setName(movie.getName());
        movieDTO.setDirector(movie.getDirector());
        movieDTO.setYear(movie.getYear());
        return movieDTO;
    }
 
    public Movie Movie(MovieDTO movieDTO){
        Movie movie = new Movie();
        movie.setName(movieDTO.getName());
        movie.setDuration(movieDTO.getDuration());
        movie.setId(movieDTO.getId());
        movie.setDirector(movieDTO.getDirector());
        movie.setYear(movieDTO.getYear());
        return movie;
    }

    public movieGroup.model.Movie toMovie(MovieDTO movieDTO) {
        Movie movie = new Movie();
        movie.setName(movieDTO.getName());
        movie.setDuration(movieDTO.getDuration());
        movie.setId(movieDTO.getId());
        movie.setDirector(movieDTO.getDirector());
        movie.setYear(movieDTO.getYear());
        return movie;
    }

}
