package br.com.bruno.cadastro.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName = "Adress")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBDocument
public class AdressEntity {
    @DynamoDBHashKey
    @DynamoDBAttribute
    String cep;
    @DynamoDBAttribute
    String logradouro;
    @DynamoDBAttribute
    String numero;
    @DynamoDBAttribute
    String complemento;
    @DynamoDBAttribute
    String bairro;
    @DynamoDBAttribute
    String localidade;
    @DynamoDBAttribute
    String uf;


}