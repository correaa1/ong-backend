package br.com.bruno.cadastro.services.impl;

import br.com.bruno.cadastro.domain.UsersEntity;
import br.com.bruno.cadastro.repository.UserRepository;
import br.com.bruno.cadastro.services.UsersService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZonedDateTime;

@Service

public class UsersServiceImpl implements UsersService {

    @Autowired
    UserRepository repository;
    @Override
    public UsersEntity saveUsers(UsersEntity entidade){
        entidade.setCreate_at(LocalDate.now().toString());
        var retorno = repository.save(entidade);
        return retorno;
    }

    @Override
    public UsersEntity updateUsers(UsersEntity entidade, String id) {
      var findId = repository.findById(id);
      if (findId.isPresent()){
          findId.get().setNome(entidade.getNome());
          findId.get().setUpdate_at(LocalDate.now().toString());
          var retorno = repository.save(findId.get());
          return retorno;

      }
      throw new RuntimeException("Usuário não encontrado");
      }

    @Override
    public void deleteUser(String id) {
      var findId = repository.findById(id);
      if(findId.isPresent()){
          repository.deleteById(id);

      }
     else{ throw new RuntimeException("Usuário não encontrado");}
    }


}
