package br.com.bruno.cadastro.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@DynamoDBTable(tableName = "Endereco")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    String id;
    @DynamoDBAttribute
    String cep;
    @DynamoDBAttribute
    String logradouro;
    @DynamoDBAttribute
    String complemento;
    @DynamoDBAttribute
    String bairro;
    @DynamoDBAttribute
    String localidade;
    @DynamoDBAttribute
    String uf;
    @DynamoDBAttribute
    String createdAt;
    @DynamoDBAttribute
    String updatedAt;
}