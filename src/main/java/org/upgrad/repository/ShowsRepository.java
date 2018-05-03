package org.upgrad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import org.upgrad.model.Movies;
import org.upgrad.model.Shows;

import java.util.List;

@Repository
public interface ShowsRepository extends CrudRepository<Shows, Integer> {

    @Query(nativeQuery = true,value="SELECT  * FROM SHOWS WHERE UPPER(CITY) = UPPER (?1) ")
    List<Shows> findAllShowsByCity(String city1);

    @Query(nativeQuery = true,value="SELECT DISTINCT CITY FROM SHOWS ")
    List<String> findAllCity();

    @Query(nativeQuery = true,value="SELECT  * FROM SHOWS WHERE SHOWID=?1 AND AVAILABILITY >= ?2 AND date>=NOW()  ")
    String findTicketAvailability(int showId,int quantity);

    @Query(nativeQuery = true,value="update shows set availability=availability-?2 where showid=?1; ")
    List<String> findBooking(int showId,int quantity);
}

