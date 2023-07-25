package br.com.bruno.cadastro.controller;

import br.com.bruno.cadastro.domain.EnderecoEntity;
import br.com.bruno.cadastro.services.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/endereco")
public class EnderecoController {
    private final EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @PostMapping
    public EnderecoEntity saveEndereco(@RequestBody EnderecoEntity entity){
        var retorno = service.saveEndereco(entity);
                return retorno;
    }
    @PutMapping("/{id}")
    public EnderecoEntity updateEndereco(@RequestBody EnderecoEntity entity, @PathVariable("id") String id){
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
    public EnderecoEntity getEnderecoId(@PathVariable("id")String id){
       return service.getEnderecoId(id);
    }
}
