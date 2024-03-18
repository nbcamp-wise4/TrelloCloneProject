package com.sparta.trellocloneproject.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="users")
public class User  {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ID;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String name;

}
