package com.example.demo.stock.Service;

import com.example.demo.stock.Entites.Users;
import com.example.demo.stock.Entites.Warehouse;
import com.example.demo.stock.Repository.UsersRepository;
import com.example.demo.stock.Repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;
   private final WarehouseRepository warehouseRepository;
    @Autowired
 /*public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }*/

   public UsersService(UsersRepository usersRepository, WarehouseRepository warehouseRepository) {
        this.usersRepository = usersRepository;
        this.warehouseRepository = warehouseRepository;
    }

    public List<Users> getUsers() {
        return usersRepository.findAll();
    }

    public void addNewUser(Users user) {
        Optional<Users> usersById= usersRepository.findById(user.getId());
        if (usersById.isPresent())
        {
            throw new IllegalStateException("L'user avec ce Id exist déja");
        }
        Optional <Warehouse> warehouseById=warehouseRepository.findById(user.getWarehouse().getId());
        if (!warehouseById.isPresent() )
        {
            warehouseRepository.save(user.getWarehouse());
           //warehouseRepository.save(user.getWarehouse().getEmployee());
        }
            usersRepository.save(user);

    }

    public void deleteUser(Long id) {
        boolean exist= usersRepository.existsById(id);
        if (!exist){
            throw new IllegalStateException( "User with"+id+" does not exist");
        }
        else
            usersRepository.deleteById(id);
    }
    @Transactional
    public void updateUser(Long id, String firstName) {
       Users user=usersRepository.findById(id).orElseThrow(() -> new IllegalStateException("Users with :"+id+ "does not exist"));
        if (firstName !=null && firstName.length() >0 && !Objects.equals(user.getFirstName(), firstName))
        {
            user.setFirstName(firstName);
        }
    }
}
