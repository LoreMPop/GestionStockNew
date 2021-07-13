package com.example.demo.stock.Service;

import com.example.demo.stock.Entites.Warehouse;
import com.example.demo.stock.Repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class WarehouseService {
    private final WarehouseRepository warehouseRepository;
    @Autowired
    public WarehouseService(WarehouseRepository warehouseRepository) {
        this.warehouseRepository = warehouseRepository;
    }

    public List<Warehouse> getWarehouse() {
        return warehouseRepository.findAll();
    }

    public void addNewWarehouse(Warehouse warehouse) {
        Optional<Warehouse> warehouseById= warehouseRepository.findById(warehouse.getId());
          if (warehouseById.isPresent())
          {
              throw new IllegalStateException("L'entrepot exist déja");
          }

        warehouseRepository.save(warehouse);
    }

    public void deleteWarehouse(Long id) {
     boolean exist= warehouseRepository.existsById(id);
     if (!exist){
         throw new IllegalStateException( "Warehouse with"+id+" does not exist");
     }
     else
         warehouseRepository.deleteById(id);
    }
@Transactional
    public void updateWarehouse(Long id, String address) {
      Warehouse warehouse=warehouseRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with :"+id+ "does not exist"));
        if (address !=null && address.length() >0 && !Objects.equals(warehouse.getAddress(), address))
        {
            warehouse.setAddress(address);
        }
    }
}
