package br.com.bruno.cadastro.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_users")
public class UsersEntity {
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
    private String create_at;
    private String update_at;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private InfoUsersEntity infoUsers;

    @OneToMany(mappedBy = "mainUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FamilyMemberEntity> familyMembers;
}
