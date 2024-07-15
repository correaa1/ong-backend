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
    public DeliveryEntity saveUserDelivery(@RequestBody DeliveryEntity delivery) {
        return service.saveUserDelivery(delivery);
    }

    @GetMapping
    public List<DeliveryEntity> getUsersDelivery() {
        return service.getUsersDelivery();
    }

    @GetMapping("/{month}")
    public List<DeliveryEntity> getDeliveriesByMonth(@PathVariable String month) {
        return service.getDeliveriesByMonth(month);
    }

    @DeleteMapping("/{idDelivery}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDelivery(@PathVariable("idDelivery") Long id) {
        service.deleteDelivery(id);
    }
}
