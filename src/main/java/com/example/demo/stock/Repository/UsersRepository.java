package com.example.demo.stock.Repository;

import com.example.demo.stock.Entites.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    // @Query("SELECT s FROM Warehouse w WHERE w.address")
    Optional<Users> findUsersByFirstName(String firstname);

}
