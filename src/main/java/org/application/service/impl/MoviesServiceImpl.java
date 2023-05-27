package org.application.service.impl;

import java.util.Optional;
import org.application.model.Movie;
import org.application.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoviesServiceImpl {
	
	@Autowired
	private MovieRepository movieRepository;

	public Optional<Movie> getMovieById(String movieId) {
        return movieRepository.findBy_id(movieId);
        
    }
}
