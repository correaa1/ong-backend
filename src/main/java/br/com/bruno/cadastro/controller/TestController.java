package br.com.bruno.cadastro.controller;

import br.com.bruno.cadastro.domain.UsersEntity;
import br.com.bruno.cadastro.services.UsersService;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;

@RestController
public class TestController {
    private final UsersService service;

    public TestController(UsersService service) {
        this.service = service;
    }

    @GetMapping
    public String helloWorld(){
        return "HelloWorld";
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

