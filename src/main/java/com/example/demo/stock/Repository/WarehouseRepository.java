package com.example.demo.stock.Repository;

import com.example.demo.stock.Entites.Users;
import com.example.demo.stock.Entites.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long>{
   // @Query("SELECT s FROM Warehouse w WHERE w.address")
    Optional<Warehouse> findWarehouseByAddress(String address);


}
