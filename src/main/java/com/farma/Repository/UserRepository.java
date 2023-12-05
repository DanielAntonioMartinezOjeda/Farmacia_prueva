package com.farma.Repository;


import com.farma.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    //@Query("SELECT u from User u Where u.username = :username")
   // public User getUserByUsername(@Param("username") String username);

    @Query("SELECT u from User u Where u.email = :email")
    public User findByEmail(@Param("email") String email);



    //public Optional<User> findByUsername(String username);


    //@Query("SELECT u from User u Where u.email = :email")
    //public User getUserByemail(@Param("username") String email);

  //  public Optional<User> findByemail(String email);
}
