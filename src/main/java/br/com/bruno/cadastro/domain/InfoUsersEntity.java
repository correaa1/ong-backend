package br.com.bruno.cadastro.domain;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
@Table(name = "tb_info_users")
public class InfoUsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    Integer phone;
    String clothingSize;
    Integer shoe;
    Integer amountParent;
    Integer amountChildren;
    String note;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    UsersEntity user;
}
