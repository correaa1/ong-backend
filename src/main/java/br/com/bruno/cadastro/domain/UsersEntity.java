package br.com.bruno.cadastro.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.*;


import java.math.BigDecimal;
import java.time.LocalDate;

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
    BigDecimal shoeSize;
    Integer numberParent;
    Integer numberChildren;
    String note;
    Boolean stats;
    AdressEntity adress;
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    String create_at;

    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    String update_at;
}
