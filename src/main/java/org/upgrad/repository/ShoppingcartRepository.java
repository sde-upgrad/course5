package org.upgrad.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import org.upgrad.model.Shoppingcart;
import org.upgrad.model.Shows;

import java.util.List;

public interface ShoppingcartRepository extends CrudRepository<Shoppingcart, Integer>  {

    @Transactional
    @Modifying
    @Query(nativeQuery = true,value="INSERT INTO shoppingcart values (DEFAULT,?3,?2,?1) ")
    void addCartDetails(int userId,int showId,int quantity);

    @Query(nativeQuery = true,value="SELECT  * FROM shoppingcart WHERE USERID = ?1 ")
    String findUseridExist(String user1);


    @Query(nativeQuery = true,value="SELECT * FROM shoppingcart WHERE USERID=?1 ")
    List<Shoppingcart> findCartDetailsViaUserId(int userId);

}
