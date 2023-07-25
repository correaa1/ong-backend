package br.com.bruno.cadastro.repository;

import br.com.bruno.cadastro.domain.EnderecoEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableScan
@Repository
public interface EnderecoRepository extends CrudRepository<EnderecoEntity, String> {
    @Override
    Optional<EnderecoEntity> findById(String s);
}
