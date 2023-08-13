package br.com.bruno.cadastro.controller;

import br.com.bruno.cadastro.domain.DeliveryEntity;
import br.com.bruno.cadastro.services.DeliveryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/delivery")
public class DeliveryController {
    private final DeliveryService service;

    public DeliveryController(DeliveryService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public List<DeliveryEntity> saveUsersDelivery(@RequestBody List<DeliveryEntity> entidades) {
        return service.saveUsersDelivery(entidades);
    }

    @GetMapping
    public List<DeliveryEntity> getUsersDelivery(){
        return service.getUsersDelivery();
    }
}
