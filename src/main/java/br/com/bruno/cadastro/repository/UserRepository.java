package br.com.bruno.cadastro.repository;

import br.com.bruno.cadastro.domain.UsersEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends CrudRepository<UsersEntity,String> {

}