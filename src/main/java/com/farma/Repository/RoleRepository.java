package com.farma.Repository;

import com.farma.Model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

/*
    @Query("SELECT u from User u Where u.name = :name")
    public User getUserByRolername(@Param("name") String name);
*/
//public Role findByName(String role);

}
