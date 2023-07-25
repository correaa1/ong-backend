package br.com.bruno.cadastro.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.*;


import java.time.LocalDate;


@DynamoDBTable(tableName = "Users")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UsersEntity {
    @DynamoDBHashKey
    String id;
    String nome;

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    String create_at;

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    String update_at;
}
