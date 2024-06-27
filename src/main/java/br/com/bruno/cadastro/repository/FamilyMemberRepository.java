package br.com.bruno.cadastro.repository;

import br.com.bruno.cadastro.domain.FamilyMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMemberEntity, String> {
}
