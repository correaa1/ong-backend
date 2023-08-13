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
public class DeliveryMouthEntity {
    Boolean janeiro;
    Boolean fevereiro;
    Boolean marco;
    Boolean abril;
    Boolean maio;
    Boolean junho;
    Boolean julho;
    Boolean agosto;
    Boolean setembro;
    Boolean outubro;
    Boolean novembro;
    Boolean dezembro;
}
