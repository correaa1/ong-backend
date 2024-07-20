package br.com.bruno.cadastro.repository;

import br.com.bruno.cadastro.domain.FamilyMemberEntity;
import org.springframework.data.repository.CrudRepository;

public interface FamilyMemberRepository extends CrudRepository<FamilyMemberEntity, String> {
}
