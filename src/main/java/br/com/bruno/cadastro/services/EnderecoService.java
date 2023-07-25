package br.com.bruno.cadastro.services;

import br.com.bruno.cadastro.domain.EnderecoEntity;
import br.com.bruno.cadastro.domain.UsersEntity;

import java.util.List;

public interface EnderecoService {

    EnderecoEntity saveEndereco(EnderecoEntity entidade);

    EnderecoEntity updateEndereco(EnderecoEntity entidade, String id);

    void deleteEndereco(String id);

    List<Object> getAllEndereco();

    EnderecoEntity getEnderecoId(String id);
}


