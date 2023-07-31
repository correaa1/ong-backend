package br.com.bruno.cadastro.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@DynamoDBDocument
public class InfoUsersEntity {
    Integer phone;
    String clothingSize;
    Integer shoe;
    Integer amountParent;
    Integer amountChildren;
    String note;

}
