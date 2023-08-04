package br.com.bruno.cadastro.services;

import br.com.bruno.cadastro.domain.UsersEntity;

import java.util.List;


public interface UsersService {

    UsersEntity saveUsers(UsersEntity entidade);
    UsersEntity updateUsers(UsersEntity entidade, String id);

    void deleteUser(String id);

    List<UsersEntity> getAllUsers();

    List<UsersEntity> getUserByStats(boolean stats);
    List<UsersEntity> getUserByName(String name);


    List<UsersEntity> getUsersByAddress(String address);


    UsersEntity getUserById(String id);


    List<UsersEntity> getByMainparatById(String idMainParent);
}
