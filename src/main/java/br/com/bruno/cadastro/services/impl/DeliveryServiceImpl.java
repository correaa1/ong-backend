package br.com.bruno.cadastro.services.impl;

import br.com.bruno.cadastro.domain.DeliveryEntity;
import br.com.bruno.cadastro.domain.FamilyEntity;
import br.com.bruno.cadastro.repository.DeliveryRepository;
import br.com.bruno.cadastro.services.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository repository;

    @Autowired
    public DeliveryServiceImpl(DeliveryRepository repository) {
        this.repository = repository;
    }

    @Override
    public DeliveryEntity saveUserDelivery(DeliveryEntity delivery) {
        return repository.save(delivery);
    }

    @Override
    public List<DeliveryEntity> getUsersDelivery() {
        return (List<DeliveryEntity>) repository.findAll();
    }

    @Override
    public List<DeliveryEntity> getDeliveriesByMonth(String month) {
        return repository.findByMonth(month);
    }

    @Override
    public void removeUsersFromDelivery(String month, List<String> userIds) {
        // Encontre todas as entregas para o mês especificado
        List<DeliveryEntity> deliveries = repository.findByMonth(month);

        for (DeliveryEntity delivery : deliveries) {
            // Filtra a lista de usuários para remover aqueles que têm IDs na lista fornecida
            List<FamilyEntity> updatedUsers = delivery.getUsers().stream()
                    .filter(user -> !userIds.contains(user.getId()))
                    .collect(Collectors.toList());

            if (!updatedUsers.isEmpty()) {
                delivery.setUsers(updatedUsers);
                repository.save(delivery);
            } else {
                repository.delete(delivery);
            }
        }
    }
}

