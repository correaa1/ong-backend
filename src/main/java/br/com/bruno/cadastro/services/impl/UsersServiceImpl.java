package br.com.bruno.cadastro.services.impl;

import br.com.bruno.cadastro.domain.UsersEntity;
import br.com.bruno.cadastro.exception.EntityNotFoundException;
import br.com.bruno.cadastro.repository.UserRepository;
import br.com.bruno.cadastro.services.UsersService;
import org.apache.http.HttpException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {


    private final UserRepository repository;

    public UsersServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UsersEntity saveUsers(UsersEntity entidade) {
        entidade.setCreate_at(LocalDate.now().toString());
        return repository.save(entidade);

    }

    @Override
    public UsersEntity updateUsers(UsersEntity entidade, String id) {
        var findId = repository.findById(id);
        if (findId.isPresent()) {
            findId.get().setNome(entidade.getNome());
            findId.get().setUpdate_at(LocalDate.now().toString());
            return repository.save(findId.get());


        }
        throw new EntityNotFoundException("Usuário não encontrado!");
    }

    @Override
    public void deleteUser(String id) {
        var findId = repository.findById(id);
        if (findId.isPresent()) {
            repository.deleteById(id);

        } else {
            throw new EntityNotFoundException("Usuário não encontrado.!");
        }
    }

    @Override
    public List<Object> getAllUsers() {
        var retorno = repository.findAll();
        var listDeUsersEntity = new ArrayList<>();
        retorno.forEach(x -> listDeUsersEntity.add(x));
        return listDeUsersEntity.stream().toList();
    }

    @Override
    public UsersEntity getUserById(String id) {
        return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("Usuário de ID " + id + " não encontrado!" ));

        //Codigo a baixo e tem o mesmo efeito do de cima
        /*var retorno = repository.findById(id);
        if (retorno.isPresent()){
            return retorno.get();
        }
        throw new RuntimeException("Usuário não encontrado");*/
    }


}
