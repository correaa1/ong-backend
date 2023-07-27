package br.com.bruno.cadastro.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperFieldModel;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTyped;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class InfoUsersEntity {
    @DynamoDBAttribute
    Integer phone;
    @DynamoDBAttribute
    String clothingSize;
    @DynamoDBAttribute
    Integer shoe;
    @DynamoDBAttribute
    Integer amountParent;
    @DynamoDBAttribute
    Integer amountChildren;
    @DynamoDBAttribute
    String note;
    @DynamoDBAttribute
    Boolean stats;

}
