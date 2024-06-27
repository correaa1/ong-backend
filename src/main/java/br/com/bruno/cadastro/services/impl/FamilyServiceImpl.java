package br.com.bruno.cadastro.services.impl;

import br.com.bruno.cadastro.domain.FamilyEntity;
import br.com.bruno.cadastro.exception.EntityNotFoundException;
import br.com.bruno.cadastro.repository.FamilyRepository;
import br.com.bruno.cadastro.services.FamilyService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService {

    private final FamilyRepository repository;

    public FamilyServiceImpl(FamilyRepository repository) {
        this.repository = repository;
    }

    @Override
    public FamilyEntity saveUsers(FamilyEntity entity) {
        entity.setCreate_at(LocalDate.now().toString());
        return repository.save(entity);
    }

    @Override
    public FamilyEntity updateUsers(FamilyEntity entity, String id) {
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
    public List<FamilyEntity> getAllUsers() {
        Iterable<FamilyEntity> usersIterable = repository.findAll();
        List<FamilyEntity> usersList = new ArrayList<>();
        usersIterable.forEach(usersList::add);
        return usersList;
    }

    @Override
    public List<FamilyEntity> getUsersByAddress(String address) {
        return null;
    }

    @Override
    public FamilyEntity getUserById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
    }

    @Override
    public List<FamilyEntity> getUserByStats(boolean stats, boolean mainParent) {
        return null;
    }
}
