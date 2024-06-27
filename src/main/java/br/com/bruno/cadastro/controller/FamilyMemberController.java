package br.com.bruno.cadastro.controller;

import br.com.bruno.cadastro.domain.FamilyMemberEntity;
import br.com.bruno.cadastro.services.FamilyMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1/family-members")
public class FamilyMemberController {

    private final FamilyMemberService service;

    public FamilyMemberController(FamilyMemberService service) {
        this.service = service;
    }

    @PostMapping("/{userId}")
    @ResponseStatus(HttpStatus.CREATED)
    public FamilyMemberEntity saveFamilyMember(@RequestBody FamilyMemberEntity entity, @PathVariable("userId") String userId) {
        return service.saveFamilyMember(entity, userId);
    }


    @GetMapping("/{id}")
    public FamilyMemberEntity getFamilyMemberById(@PathVariable("id") String id) {
        return service.getFamilyMemberById(id);
    }


    @PutMapping("/{id}")
    public FamilyMemberEntity updateFamilyMember(@RequestBody FamilyMemberEntity entity, @PathVariable("id") String id) {
        return service.updateFamilyMember(entity, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFamilyMember(@PathVariable("id") String id) {
        service.deleteFamilyMember(id);
    }
}
