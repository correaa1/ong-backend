package br.com.bruno.cadastro.controller;

import br.com.bruno.cadastro.domain.DeliveryEntity;
import br.com.bruno.cadastro.domain.FamilyEntity;
import br.com.bruno.cadastro.services.DeliveryService;
import br.com.bruno.cadastro.services.FamilyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/delivery")
public class DeliveryController {

    private final DeliveryService service;
    private final FamilyService familyService;

    public DeliveryController(DeliveryService service, FamilyService familyService) {
        this.service = service;
        this.familyService = familyService;
    }

    public static class DeliveryRequest {
        public String month;
        public String name;
        public List<String> userIds;

        // Getters e Setters
        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<String> getUserIds() {
            return userIds;
        }

        public void setUserIds(List<String> userIds) {
            this.userIds = userIds;
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DeliveryEntity saveUserDelivery(@RequestBody DeliveryRequest deliveryRequest) {

        List<FamilyEntity> users = familyService.getFamilyMembersByIds(deliveryRequest.getUserIds());

        DeliveryEntity delivery = new DeliveryEntity();
        delivery.setMonth(deliveryRequest.getMonth());
        delivery.setName(deliveryRequest.getName());
        delivery.setUsers(users);

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
