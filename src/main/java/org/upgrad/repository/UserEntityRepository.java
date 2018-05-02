package org.upgrad.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.upgrad.model.Shows;
import org.upgrad.model.Userentity;

import java.util.List;

public interface UserEntityRepository extends CrudRepository<Userentity, Integer>  {

    @Query(nativeQuery = true,value="SELECT  * FROM SHOWS WHERE UPPER(CITY) = UPPER (?1) ")
    List<Shows> findSignUpPossiblity(String city1);


}
