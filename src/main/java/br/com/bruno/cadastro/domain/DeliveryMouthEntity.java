package br.com.bruno.cadastro.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

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
