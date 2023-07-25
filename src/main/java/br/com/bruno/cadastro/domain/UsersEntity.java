package br.com.bruno.cadastro.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.*;


import java.time.LocalDate;
/*campos de cadastro: nome, idade, endereco, telefone, tamanho de roupa,
 tamanho do calçado, quantidade de pessoas(referente a familia), quantidade de crianças,
 campo de observações, campo de status(ativo ou inativo)*/

@DynamoDBTable(tableName = "Users")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UsersEntity {
    @DynamoDBHashKey
    String id;
    String name;
    String cpf;
    Integer phone;
    String clothingSize;
    Integer shoe;
    Integer numberParent;
    Integer numberchildren;
    String note;
    Boolean stats;


    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    String create_at;

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    String update_at;
}
