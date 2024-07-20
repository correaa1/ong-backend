package br.com.bruno.cadastro.services.impl;

import br.com.bruno.cadastro.domain.FamilyEntity;
import br.com.bruno.cadastro.exception.EntityNotFoundException;
import br.com.bruno.cadastro.repository.FamilyRepository;
import br.com.bruno.cadastro.services.FamilyService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FamilyServiceImpl implements FamilyService {

    private final FamilyRepository repository;

    public FamilyServiceImpl(FamilyRepository repository) {
        this.repository = repository;
    }

    @Override
    public FamilyEntity saveUsers(FamilyEntity entity) {
        entity.setCreatedAt(LocalDate.now().toString());
        return repository.save(entity);
    }

    @Override
    public FamilyEntity updateUsers(FamilyEntity entity, String id) {
        Optional<FamilyEntity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            FamilyEntity existingEntity = optionalEntity.get();
            existingEntity.setName(entity.getName());
            existingEntity.setAge(entity.getAge());
            existingEntity.setStats(entity.getStats());
            existingEntity.setPhone(entity.getPhone());
            existingEntity.setClothingSize(entity.getClothingSize());
            existingEntity.setShoe(entity.getShoe());
            existingEntity.setAmountParent(entity.getAmountParent());
            existingEntity.setAmountChildren(entity.getAmountChildren());
            existingEntity.setNote(entity.getNote());
            existingEntity.setUpdatedAt(LocalDate.now().toString());
            return repository.save(existingEntity);
        } else {
            throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);
        }
    }

    @Override
    public void deleteUser(String id) {
        Optional<FamilyEntity> optionalEntity = repository.findById(id);
        if (optionalEntity.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);
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

    @Override
    public List<FamilyEntity> getFamilyMembersByIds(List<String> ids) { // Implementação do novo método
        List<FamilyEntity> familyMembers = new ArrayList<>();
        for (String id : ids) {
            FamilyEntity familyMember = repository.findById(id)
                    .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
            familyMembers.add(familyMember);
        }
        return familyMembers;
    }
}
