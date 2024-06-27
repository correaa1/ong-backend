package br.com.bruno.cadastro.controller;

import br.com.bruno.cadastro.domain.UsersEntity;
import br.com.bruno.cadastro.services.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/users")
public class UserController {

    private final UsersService service;

    public UserController(UsersService service) {
        this.service = service;
    }

    @GetMapping("/stats")
    public List<UsersEntity> getUserByStats(@RequestParam boolean stats, @RequestParam boolean mainParent) {
        return service.getUserByStats(stats, mainParent);
    }

    @GetMapping("/address")
    public List<UsersEntity> getAllAddress() {
        return service.getUsersByAddress("address");
    }

    @GetMapping("/{id}")
    public UsersEntity getUserById(@PathVariable("id") String id) {
        return service.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsersEntity saveUser(@RequestBody UsersEntity entity) {
        return service.saveUsers(entity);
    }

    @PutMapping("/{id}")
    public UsersEntity updateUser(@RequestBody UsersEntity entity, @PathVariable("id") String id) {
        return service.updateUsers(entity, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") String id) {
        service.deleteUser(id);
    }


}
