package com.example.demo.stock.controllers;

import com.example.demo.stock.Service.WarehouseService;
import com.example.demo.stock.Entites.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/warehouse")
public class WarehouseController {
    private final WarehouseService warehouseService;
@Autowired
    public WarehouseController(WarehouseService warehouseService) {
        this.warehouseService = warehouseService;
    }

    @GetMapping
    public List<Warehouse> getWarehouse()
    {
       //
        return warehouseService.getWarehouse();
    }
    @PostMapping
    public void registerNewWarehouse(@RequestBody Warehouse warehouse)
    {
        warehouseService.addNewWarehouse(warehouse);
    }
    @DeleteMapping(path="{warehouseId}")
    public void deleteWarehouse(@PathVariable("warehouseId") Long warehouseId )
    {
        warehouseService.deleteWarehouse(warehouseId);
    }
    @PutMapping(path="{Id}")
    public void updateWarehouse(
            @PathVariable("Id") Long Id,
            @RequestParam(required = false) String address)
    {
        warehouseService.updateWarehouse(Id, address);
    }

}
