package br.com.bruno.cadastro.services;

import br.com.bruno.cadastro.domain.FamilyMemberEntity;

public interface FamilyMemberService {
    FamilyMemberEntity saveFamilyMember(FamilyMemberEntity entity, String userId);
    FamilyMemberEntity getFamilyMemberById(String id);
    FamilyMemberEntity updateFamilyMember(FamilyMemberEntity entity, String id);
    void deleteFamilyMember(String id);
}
