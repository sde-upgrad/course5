package org.upgrad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import org.upgrad.model.Movies;
import org.upgrad.model.Shows;

import javax.persistence.Cacheable;
import java.util.List;

@Component
@Repository
public interface ShowsRepository extends CrudRepository<Shows, Integer> {

    @Query(nativeQuery = true,value="SELECT  * FROM SHOWS WHERE UPPER(CITY) = UPPER (?1) ")
    List<Shows> findAllShowsByCity(String city1);

    @Query(nativeQuery = true,value="SELECT DISTINCT CITY FROM SHOWS ")
    List<String> findAllCity();

    @Query(nativeQuery = true,value="SELECT  MOVIENAME FROM SHOWS WHERE SHOWID=?1 ")
    String findMovieNameViaShow(int showId);

    @Query(nativeQuery = true,value="SELECT  * FROM SHOWS WHERE SHOWID=?1 AND AVAILABILITY >= ?2 AND date>=NOW()  ")
    String findTicketAvailability(int showId,int quantity);


    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="UPDATE SHOWS SET AVAILABILITY=(AVAILABILITY-?2) WHERE SHOWID=?1")
    void findBooking(int showId,int quantity);
}

