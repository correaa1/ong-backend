package br.com.bruno.cadastro.services;

import br.com.bruno.cadastro.domain.UsersEntity;

import java.util.List;

public interface UsersService {

    UsersEntity saveUsers(UsersEntity entity);

    UsersEntity updateUsers(UsersEntity entity, String id);

    void deleteUser(String id);

    List<UsersEntity> getAllUsers();

    List<UsersEntity> getUsersByAddress(String address);

    UsersEntity getUserById(String id);

    List<UsersEntity> getUserByStats(boolean stats, boolean mainParent);
}
