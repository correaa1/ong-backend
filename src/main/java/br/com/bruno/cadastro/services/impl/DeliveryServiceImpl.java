package br.com.bruno.cadastro.services.impl;

import br.com.bruno.cadastro.domain.DeliveryEntity;
import br.com.bruno.cadastro.repository.DeliveryRepository;
import br.com.bruno.cadastro.services.DeliveryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryServiceImpl implements DeliveryService {
    private final DeliveryRepository repository;

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
    public void deleteDelivery(Long id) {
        Optional<DeliveryEntity> delivery = repository.findById(id);
        delivery.ifPresent(repository::delete);
    }
}
