package br.com.bruno.cadastro.services.impl;

import br.com.bruno.cadastro.domain.DeliveryEntity;
import br.com.bruno.cadastro.exception.EntityNotFoundException;
import br.com.bruno.cadastro.repository.DeliveryRepository;
import br.com.bruno.cadastro.services.DeliveryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryServiceImpl implements DeliveryService {

    private final DeliveryRepository repository;


    public DeliveryServiceImpl(DeliveryRepository repository) {
        this.repository = repository;
    }




    @Override
    public List<DeliveryEntity> saveUsersDelivery(List<DeliveryEntity> entidades) {
        return (List<DeliveryEntity>) repository.saveAll(entidades);
    }

    @Override
    public List<DeliveryEntity> getUsersDelivery(){
        return (List<DeliveryEntity>) repository.findAll();
    }


}
