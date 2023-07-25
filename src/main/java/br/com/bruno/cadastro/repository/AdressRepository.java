package br.com.bruno.cadastro.repository;

import br.com.bruno.cadastro.domain.AdressEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableScan
@Repository
public interface AdressRepository extends CrudRepository<AdressEntity, String> {

}
