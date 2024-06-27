package br.com.bruno.cadastro.controller;

import br.com.bruno.cadastro.domain.FamilyEntity;
import br.com.bruno.cadastro.services.FamilyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/users")
public class FamilyController {

    private final FamilyService service;

    public FamilyController(FamilyService service) {
        this.service = service;
    }

    @GetMapping("/stats")
    public List<FamilyEntity> getUserByStats(@RequestParam boolean stats, @RequestParam boolean mainParent) {
        return service.getUserByStats(stats, mainParent);
    }

    @GetMapping("/address")
    public List<FamilyEntity> getAllAddress() {
        return service.getUsersByAddress("address");
    }

    @GetMapping("/{id}")
    public FamilyEntity getUserById(@PathVariable("id") String id) {
        return service.getUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FamilyEntity saveUser(@RequestBody FamilyEntity entity) {
        return service.saveUsers(entity);
    }

    @PutMapping("/{id}")
    public FamilyEntity updateUser(@RequestBody FamilyEntity entity, @PathVariable("id") String id) {
        return service.updateUsers(entity, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") String id) {
        service.deleteUser(id);
    }


}
