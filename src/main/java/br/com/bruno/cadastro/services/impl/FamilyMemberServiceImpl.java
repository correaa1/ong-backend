package br.com.bruno.cadastro.services.impl;

import br.com.bruno.cadastro.domain.FamilyEntity;
import br.com.bruno.cadastro.domain.FamilyMemberEntity;
import br.com.bruno.cadastro.exception.EntityNotFoundException;
import br.com.bruno.cadastro.repository.FamilyMemberRepository;
import br.com.bruno.cadastro.repository.FamilyRepository;
import br.com.bruno.cadastro.services.FamilyMemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FamilyMemberServiceImpl implements FamilyMemberService {

    private final FamilyMemberRepository repository;
    private final FamilyRepository familyRepository;

    public FamilyMemberServiceImpl(FamilyMemberRepository repository, FamilyRepository familyRepository) {
        this.repository = repository;
        this.familyRepository = familyRepository;
    }

    @Override
    @Transactional
    public FamilyMemberEntity saveFamilyMember(FamilyMemberEntity entity, String userId) {
        FamilyEntity mainUser = familyRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("Usuário principal não encontrado com ID: " + userId));

        if (mainUser.getId() == null) {
            throw new EntityNotFoundException("A FamilyEntity deve ser persistida antes de associar um FamilyMemberEntity.");
        }

        entity.setMainUser(mainUser);
        return repository.save(entity);
    }

    @Override
    public FamilyMemberEntity getFamilyMemberById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membro da família não encontrado com ID: " + id));
    }

    @Override
    @Transactional
    public FamilyMemberEntity updateFamilyMember(FamilyMemberEntity entity, String id) {
        FamilyMemberEntity existingMember = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Membro da família não encontrado com ID: " + id));

        existingMember.setName(entity.getName());
        existingMember.setAge(entity.getAge());
        existingMember.setStats(entity.getStats());

        return repository.save(existingMember);
    }

    @Override
    @Transactional
    public void deleteFamilyMember(String id) {
        repository.deleteById(id);
    }
}
