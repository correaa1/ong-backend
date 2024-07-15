package br.com.bruno.cadastro.repository;

import br.com.bruno.cadastro.domain.DeliveryEntity;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface DeliveryRepository extends CrudRepository<DeliveryEntity, Long> {
    List<DeliveryEntity> findByMonth(String month);
}
