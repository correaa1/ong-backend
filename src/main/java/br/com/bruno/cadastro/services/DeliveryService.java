package br.com.bruno.cadastro.services;

import br.com.bruno.cadastro.domain.DeliveryEntity;
import java.util.List;

public interface DeliveryService {

    List<DeliveryEntity> saveUsersDelivery(List<DeliveryEntity> entidades);

    void deleteUser(String idDelivery);

    List<DeliveryEntity> getUsersDelivery();
}
