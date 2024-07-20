package br.com.bruno.cadastro.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class DeliveryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String month;

    @ManyToMany
    @JoinTable(
            name = "delivery_user",
            joinColumns = @JoinColumn(name = "delivery_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<FamilyEntity> users;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<FamilyEntity> getUsers() {
        return users;
    }

    public void setUsers(List<FamilyEntity> users) {
        this.users = users;
    }
}
