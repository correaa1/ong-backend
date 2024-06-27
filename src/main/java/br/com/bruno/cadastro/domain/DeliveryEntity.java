package br.com.bruno.cadastro.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table (name="tb_delivery")
public class DeliveryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String idDelivery;
    String nameUser;
    String idUser;
    String create_at;
    String update_at;
}
