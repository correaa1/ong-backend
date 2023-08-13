package br.com.bruno.cadastro.domain;
import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.*;


@DynamoDBTable(tableName = "Users")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UsersEntity {
    @DynamoDBHashKey
    String id;
    String name;
    DeliveryMouthEntity deliveryMonth;
    Boolean stats;
    Boolean mainParent;
    String idMainParent;
    InfoUsersEntity infoUsers;
    AddressEntity address;
    String idMainParentRelational;
    String create_at;
    String update_at;

}
