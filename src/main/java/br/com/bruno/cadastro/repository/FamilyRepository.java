package br.com.bruno.cadastro.repository;

import br.com.bruno.cadastro.domain.FamilyEntity;
import org.springframework.data.repository.CrudRepository;

public interface FamilyRepository extends CrudRepository<FamilyEntity, String> {
}
