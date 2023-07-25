package br.com.bruno.cadastro.services;

import br.com.bruno.cadastro.domain.UsersEntity;


public interface UsersService {

    UsersEntity saveUsers(UsersEntity entidade);
    UsersEntity updateUsers(UsersEntity entidade, String id);

    void deleteUser(String id);
}
