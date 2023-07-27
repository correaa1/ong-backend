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
    Boolean stats;
    InfoUsersEntity infoUsers;
    AdressEntity adress;
    String create_at;
    String update_at;

}
