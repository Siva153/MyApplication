package org.application.repository;

import java.util.Optional;

import org.application.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
	
	public Optional<Movie> findBy_id(String _id);

}
