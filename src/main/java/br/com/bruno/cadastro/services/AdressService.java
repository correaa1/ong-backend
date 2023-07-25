package br.com.bruno.cadastro.services;

import br.com.bruno.cadastro.domain.AdressEntity;

import java.util.List;

public interface AdressService {

    AdressEntity saveEndereco(AdressEntity entidade);

    AdressEntity updateEndereco(AdressEntity entidade, String id);

    void deleteEndereco(String id);

    List<Object> getAllEndereco();

    AdressEntity getEnderecoId(String id);
}


