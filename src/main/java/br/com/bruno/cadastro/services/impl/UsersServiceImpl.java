package br.com.bruno.cadastro.services.impl;

import br.com.bruno.cadastro.domain.UsersEntity;
import br.com.bruno.cadastro.repository.UserRepository;
import br.com.bruno.cadastro.services.UsersService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service

public class UsersServiceImpl implements UsersService {


    private final UserRepository repository;

    public UsersServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UsersEntity saveUsers(UsersEntity entidade){
        entidade.setCreate_at(LocalDate.now().toString());
        return repository.save(entidade);

    }

    @Override
    public UsersEntity updateUsers(UsersEntity entidade, String id) {
      var findId = repository.findById(id);
      if (findId.isPresent()){
          findId.get().setNome(entidade.getNome());
          findId.get().setUpdate_at(LocalDate.now().toString());
          return repository.save(findId.get());


      }
      throw new RuntimeException("Usuário não encontrado");
      }

    @Override
    public void deleteUser(String id) {
      var findId = repository.findById(id);
      if(findId.isPresent()){
          repository.deleteById(id);

      }else{ throw new RuntimeException("Usuário não encontrado");}
    }


}
