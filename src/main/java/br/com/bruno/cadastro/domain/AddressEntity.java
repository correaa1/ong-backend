package br.com.bruno.cadastro.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class AddressEntity {
    String zipCode;
    String numero;
    String bairro;
    String street;
}