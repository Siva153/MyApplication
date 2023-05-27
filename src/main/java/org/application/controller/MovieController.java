package org.application.controller;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.application.exception.InternalServerException;
import org.application.exception.MovieNotFoundException;
import org.application.model.Movie;
import org.application.service.impl.MoviesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
	
	@Autowired
	private MoviesServiceImpl moviesServiceImpl;
	
	@GetMapping("/getMovie/{movieId}")
	public ResponseEntity<Movie> getMovieById(@PathVariable("movieId") String movieId){
		try{
		Movie movie =  moviesServiceImpl.getMovieById(movieId).orElseThrow(() -> new MovieNotFoundException("Movie not found with ID: " + movieId));
		return ResponseEntity.ok(movie);
		} catch(MovieNotFoundException ex){
			throw ex;
		}
		catch(Exception ex){
			throw new InternalServerException("An error occurred while retrieving the movie",ex);
		}
       
	}
	
	@ExceptionHandler(MovieNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleMovieNotFoundException(MovieNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<String> handleInternalServerErrorException(InternalServerException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

}
