package com.example.loginback.Security.IRepository;

import java.util.Optional;

import com.example.loginback.Security.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//nos prove lo metodos para el crud basico
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);

    @Modifying
    @Query("update User u set u.firstname = :#{#user.firstname}, u.lastname = :#{#user.lastname}, u.country = :#{#user.country}, u.role = :#{#user.role} where u.id = :#{#user.id}")
    void updateUser(@Param("user") User user);

}
