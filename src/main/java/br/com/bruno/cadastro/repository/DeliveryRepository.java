package br.com.bruno.cadastro.repository;

import br.com.bruno.cadastro.domain.DeliveryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryRepository extends CrudRepository<DeliveryEntity, String> {
}
