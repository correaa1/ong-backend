package br.com.bruno.cadastro.controller;

import br.com.bruno.cadastro.domain.AdressEntity;
import br.com.bruno.cadastro.services.AdressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/endereco")
public class AdressController {
    private final AdressService service;

    public AdressController(AdressService service) {
        this.service = service;
    }

    @PostMapping
    public AdressEntity saveEndereco(@RequestBody AdressEntity entity){
        var retorno = service.saveEndereco(entity);
                return retorno;
    }
    @PutMapping("/{id}")
    public AdressEntity updateEndereco(@RequestBody AdressEntity entity, @PathVariable("id") String id){
        var retorno = service.updateEndereco(entity, id);
                return retorno;
    }
    @DeleteMapping("/{id}")
    public void deleteEndereco(@PathVariable("id") String id ){
        service.deleteEndereco(id);
    }
    @GetMapping
    public List<Object> getAllEndereco(){
        return service.getAllEndereco();
    }
    @GetMapping("/{id}")
    public AdressEntity getEnderecoId(@PathVariable("id")String id){
       return service.getEnderecoId(id);
    }
}
