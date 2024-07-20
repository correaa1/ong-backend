package br.com.bruno.cadastro.services;

import br.com.bruno.cadastro.domain.FamilyEntity;

import java.util.List;

public interface FamilyService {

    FamilyEntity saveUsers(FamilyEntity entity);

    FamilyEntity updateUsers(FamilyEntity entity, String id);

    void deleteUser(String id);

    List<FamilyEntity> getAllUsers();

    List<FamilyEntity> getUsersByAddress(String address);

    List<FamilyEntity> getFamilyMembersByIds(List<String> ids);

    FamilyEntity getUserById(String id);

    List<FamilyEntity> getUserByStats(boolean stats, boolean mainParent);

}
