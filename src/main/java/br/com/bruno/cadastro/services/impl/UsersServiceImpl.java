package br.com.bruno.cadastro.services.impl;

import br.com.bruno.cadastro.domain.UsersEntity;
import br.com.bruno.cadastro.exception.EntityNotFoundException;
import br.com.bruno.cadastro.repository.UserRepository;
import br.com.bruno.cadastro.services.UsersService;
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
    public UsersEntity saveUsers(UsersEntity entity) {
        entity.setCreate_at(LocalDate.now().toString());
        return repository.save(entity);
    }

    @Override
    public UsersEntity updateUsers(UsersEntity entity, String id) {
        var findId = repository.findById(id);

        if (findId.isPresent()) {
            entity.setId(id);
            entity.setUpdate_at(LocalDate.now().toString());
            return repository.save(entity);
        }
        throw new EntityNotFoundException("Usuário não encontrado!");
    }

    @Override
    public void deleteUser(String id) {
        var findId = repository.findById(id);
        if (findId.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Usuário não encontrado!");
        }
    }

    @Override
    public List<UsersEntity> getAllUsers() {
        Iterable<UsersEntity> usersIterable = repository.findAll();
        List<UsersEntity> usersList = new ArrayList<>();
        usersIterable.forEach(usersList::add);
        return usersList;
    }

    @Override
    public List<UsersEntity> getUsersByAddress(String address) {
        return null;
    }

    @Override
    public UsersEntity getUserById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
    }

    @Override
    public List<UsersEntity> getUserByStats(boolean stats, boolean mainParent) {
        return null;
    }
}
