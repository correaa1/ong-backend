package br.com.bruno.cadastro.repository;

import br.com.bruno.cadastro.domain.DeliveryEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface DeliveryRepository extends CrudRepository<DeliveryEntity, String> {

}
