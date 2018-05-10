package org.upgrad.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.upgrad.model.Movies;

import java.util.Date;
import java.util.List;

@Repository
public interface MoviesRepository extends CrudRepository<Movies, Integer> {

    @Query(nativeQuery = true,value="SELECT * FROM MOVIES WHERE UPPER(NAME) = UPPER (?1) ")
    List<Movies> findMovieDetails(String name);

    @Query(nativeQuery = true,value="SELECT * FROM MOVIES WHERE release_date > NOW(); ")
    List<Movies> findUpcomingMovies();

    @Query(nativeQuery = true,value="SELECT * FROM MOVIES WHERE release_date <= NOW(); ")
    List<Movies> findReleasedMovies();

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="INSERT INTO MOVIES VALUES (DEFAULT,?2,?1,?3,?4)")
    void addNewMovies(String moviename,String description,int rating,Date date1);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="DELETE FROM MOVIES WHERE UPPER(NAME)=UPPER(?1) ")
    void deleteMoviesByName(String moviename);
}
