package br.com.bruno.cadastro.services.impl;

import br.com.bruno.cadastro.domain.FamilyMemberEntity;
import br.com.bruno.cadastro.domain.FamilyEntity;
import br.com.bruno.cadastro.exception.EntityNotFoundException;
import br.com.bruno.cadastro.repository.FamilyMemberRepository;
import br.com.bruno.cadastro.repository.FamilyRepository;
import br.com.bruno.cadastro.services.FamilyMemberService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FamilyMemberServiceImpl implements FamilyMemberService {

    private final FamilyMemberRepository repository;
    private final FamilyRepository familyRepository;

    public FamilyMemberServiceImpl(FamilyMemberRepository repository, FamilyRepository familyRepository) {
        this.repository = repository;
        this.familyRepository = familyRepository;
    }

    @Override
    public FamilyMemberEntity saveFamilyMember(FamilyMemberEntity entity, String userId) {
        FamilyEntity mainUser = familyRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário principal não encontrado com ID: " + userId));

        entity.setMainUser(mainUser); // Define o usuário principal no membro da família
        entity.setUpdate_at(LocalDate.now().toString());

        return repository.save(entity);
    }

    @Override
    public FamilyMemberEntity getFamilyMemberById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membro da família não encontrado com ID: " + id));
    }

    @Override
    public FamilyMemberEntity updateFamilyMember(FamilyMemberEntity entity, String id) {
        var existingMember = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membro da família não encontrado com ID: " + id));

        existingMember.setName(entity.getName());
        existingMember.setAge(entity.getAge());
        existingMember.setStats(entity.getStats());
        existingMember.setUpdate_at(LocalDate.now().toString());

        return repository.save(existingMember);
    }

    @Override
    public void deleteFamilyMember(String id) {
        var existingMember = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membro da família não encontrado com ID: " + id));

        repository.deleteById(id);
    }
}
