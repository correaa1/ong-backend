package br.com.bruno.cadastro.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_family_members")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class FamilyMemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private Integer age;
    private Boolean stats;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "main_user_id", referencedColumnName = "id")
    private FamilyEntity mainUser;
    private String update_at;
}
