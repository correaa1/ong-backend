package br.com.bruno.cadastro.services.impl;

import br.com.bruno.cadastro.domain.EnderecoEntity;
import br.com.bruno.cadastro.exception.EntityNotFoundException;
import br.com.bruno.cadastro.repository.EnderecoRepository;
import br.com.bruno.cadastro.services.EnderecoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoServiceImpl(EnderecoRepository repository) {
        this.repository = repository;
    }

    @Override
    public EnderecoEntity saveEndereco(EnderecoEntity entidade) {
        entidade.setCreate_at(LocalDate.now().toString());
        return repository.save(entidade);

    }
    @Override
    public EnderecoEntity updateEndereco(EnderecoEntity entidade, String id){
        var findEnderecoId = repository.findById(id);
        if (findEnderecoId.isPresent()){
            findEnderecoId.get().setCep(entidade.getCep() != null ? entidade.getCep() : findEnderecoId.get().getCep());
            findEnderecoId.get().setLogradouro(entidade.getLogradouro() != null ? entidade.getLogradouro() : findEnderecoId.get().getLogradouro());
            findEnderecoId.get().setNumero(entidade.getNumero() != null ? entidade.getNumero() : findEnderecoId.get().getNumero());
            findEnderecoId.get().setComplemento(entidade.getComplemento() != null ? entidade.getComplemento() : findEnderecoId.get().getComplemento());
            findEnderecoId.get().setBairro(entidade.getBairro() != null ? entidade.getBairro() : findEnderecoId.get().getBairro());
            findEnderecoId.get().setLocalidade(entidade.getLocalidade() != null ? entidade.getLocalidade() : findEnderecoId.get().getLocalidade());
            findEnderecoId.get().setUf(entidade.getUf() != null ? entidade.getUf() : findEnderecoId.get().getUf());
            findEnderecoId.get().setUpdate_at(LocalDate.now().toString());
        return repository.save(findEnderecoId.get());
        }
        throw new EntityNotFoundException("Endereço não encontrado!");
    }

    @Override
    public void deleteEndereco(String id) {
        var findEnderecoId = repository.findById(id);
        if(findEnderecoId.isPresent()){
            repository.deleteById(id);
        }
        else {throw new EntityNotFoundException("Este endereço não existe");
        }
    }

    @Override
    public List<Object> getAllEndereco() {
        var retorno = repository.findAll();
        var listArrayEndereco = new ArrayList<>();
        retorno.forEach(x -> listArrayEndereco.add(x));
        return listArrayEndereco.stream().toList();
    }
    @Override
    public EnderecoEntity getEnderecoId(String id){
        var findEnderecoId = repository.findById(id);
        if(findEnderecoId.isPresent()){
           return findEnderecoId.get();
        }
        throw new EntityNotFoundException("Endereço inserido não existe");
    }

}
