package org.upgrad.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.upgrad.model.Shows;
import org.upgrad.model.Userentity;

import java.util.List;

public interface UserEntityRepository extends CrudRepository<Userentity, Integer>  {

    @Query(nativeQuery = true,value="SELECT  * FROM USERENTITY WHERE UPPER(USERNAME) = UPPER (?1) ")
    String findUserExist(String city1);


    @Query(nativeQuery = true,value="INSERT INTO USERENTITY (USERNAME,PASSWORD) VALUES (?1,?2)")
    void addUserCredentials(String uname,String password);
}
