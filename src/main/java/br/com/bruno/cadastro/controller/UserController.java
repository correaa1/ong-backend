package br.com.bruno.cadastro.controller;

import br.com.bruno.cadastro.domain.UsersEntity;
import br.com.bruno.cadastro.services.UsersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("v1/user")
public class UserController {
    private final UsersService service;

    public UserController(UsersService service) {
        this.service = service;
    }

    @GetMapping
    public List<Object> helloWorld(){
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public UsersEntity getUserById(@PathVariable("id") String id){
        return  service.getUserById(id);

    }

    @PostMapping
    public UsersEntity SaveUser(@RequestBody UsersEntity entity ){
        var retorno = service.saveUsers(entity);
        return retorno;
    }
    @PutMapping("/{id}")
    public UsersEntity updateUser(@RequestBody UsersEntity entity, @PathVariable("id") String id){
        var retorno = service.updateUsers(entity, id);
        return retorno;
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") String id){
       service.deleteUser(id);

    }

}

