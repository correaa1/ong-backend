package br.com.bruno.cadastro.services.impl;

import br.com.bruno.cadastro.domain.UsersEntity;
import br.com.bruno.cadastro.exception.EntityNotFoundException;
import br.com.bruno.cadastro.repository.UserRepository;
import br.com.bruno.cadastro.services.UsersService;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {


    private final UserRepository repository;
    private String address;

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
            findId.get().setName(entidade.getName());
            findId.get().setIdMainParent(entidade.getIdMainParent());
            findId.get().setMainParent(entidade.getMainParent());
            findId.get().setStats(entidade.getStats());
            findId.get().setInfoUsers(entidade.getInfoUsers());
            findId.get().setDeliveryMonth(entidade.getDeliveryMonth());
            findId.get().setAddress(entidade.getAddress());
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
    public List<UsersEntity> getAllUsers() {
        var retorno = repository.findAll();
        List<UsersEntity> listaUserEntity = new ArrayList<>();
        retorno.forEach(x -> listaUserEntity.add(x));

        return listaUserEntity;
    }
    @Override
    public List<UsersEntity> getUserByStats(boolean stats){

        return repository.findByStats(stats).get().stream().toList();

    }

    @Override
    public List <UsersEntity>  getUserByName(String name ){

        return repository.findByName(name).get().stream().toList();
    }

    @Override
    public List<UsersEntity> getUsersByAddress(String address){
        return repository.findByAddress(address).get().stream().toList();
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


    @Override
    public List<UsersEntity> getByMainparatById(String idMainParent) {
        return repository.findByidMainParent(idMainParent).get().stream().toList();
    }


}
