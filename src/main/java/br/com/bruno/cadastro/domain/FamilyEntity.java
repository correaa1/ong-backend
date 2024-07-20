package br.com.bruno.cadastro.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_users")
public class FamilyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private Integer age;
    private Boolean stats;
    private Integer phone;
    private String clothingSize;
    private Integer shoe;
    private Integer amountParent;
    private Integer amountChildren;
    private String note;
    private String createdAt;
    private String updatedAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private InfoFamilyEntity infoUsers;

    @OneToMany(mappedBy = "mainUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FamilyMemberEntity> familyMembers;
}
