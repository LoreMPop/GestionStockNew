package com.example.demo.stock.controllers;

import com.example.demo.stock.Entites.Users;
import com.example.demo.stock.Entites.Warehouse;
import com.example.demo.stock.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UsersController {
    private final UsersService usersService;
    @Autowired
    public UsersController(UsersService userService) {
        this.usersService = userService;
    }

    @GetMapping
    public List<Users> getUsers()
    {
        //
        return usersService.getUsers();
    }
    @PostMapping
    public void registerNewUser(@RequestBody Users user)
    {
        usersService.addNewUser(user);
    }
    @DeleteMapping(path="{userId}")
    public void deleteUser(@PathVariable("userId") Long userId )
    {
        usersService.deleteUser(userId);
    }
    @PutMapping(path="{Id}")
    public void updateUsers(
            @PathVariable("Id") Long Id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String warehouseId)
    {
        usersService.updateUser(Id, firstName);
    }

}