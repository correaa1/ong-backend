package br.com.bruno.cadastro.services;

import br.com.bruno.cadastro.domain.DeliveryEntity;
import java.util.List;

public interface DeliveryService {
    DeliveryEntity saveUserDelivery(DeliveryEntity delivery);

    List<DeliveryEntity> getUsersDelivery();

    List<DeliveryEntity> getDeliveriesByMonth(String month);

    void deleteDelivery(Long id);
}
