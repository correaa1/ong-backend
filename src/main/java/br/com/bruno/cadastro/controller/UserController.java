package br.com.bruno.cadastro.controller;

import br.com.bruno.cadastro.domain.UsersEntity;
import br.com.bruno.cadastro.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/users")
public class UserController {
    private final UsersService service;

    public UserController(UsersService service) {
        this.service = service;
    }

    @GetMapping
    public List<Object> getAllUsers(){
        return service.getAllUsers();
    }

    @GetMapping("/stats")
    public  List<UsersEntity> getUserByStats(){

        return service.getUserByStats(true);
    }
    @GetMapping("/{name}")
    public  List <UsersEntity>  getUserByName(@PathVariable("name") String name) {

        return service.getUserByName(name);

    }

    @GetMapping("/address")
    public  List<UsersEntity> getAllAddress(){
        return service.getUsersByAddress("address");
    }

    //por algum motivo que não sei, o getMapping name está executando esse getMapping de id, por isso está comentado o código abaixo
    /*@GetMapping("/{id}")
    public UsersEntity getUserById(@PathVariable("id") String id){
        return service.getUserById(id);

    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") String id){
       service.deleteUser(id);

    }

}

