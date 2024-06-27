package br.com.bruno.cadastro.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String district;
    String street;
    String number;
    String zipCode;


}