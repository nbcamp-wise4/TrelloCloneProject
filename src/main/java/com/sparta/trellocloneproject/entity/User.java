package com.sparta.trellocloneproject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="users")
public class User extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
//    @OneToMany
//    private List<Board> boards;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String name;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private UserRoleEnum role;

    public User(String username, String password, UserRoleEnum role, String name) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof User user)) return false;
        return Objects.equals(getID(), user.getID());
    }

}