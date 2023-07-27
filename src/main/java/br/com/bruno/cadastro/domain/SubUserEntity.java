package br.com.bruno.cadastro.domain;


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
public class SubUserEntity {
    String name;
    InfoUsersEntity infoUsers;
    AddressEntity address;
}
