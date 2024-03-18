package com.sparta.trellocloneproject.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="card")
public class Card {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ID;
    @Column
    private String title;
    @Column
    private String description;
    @Column
    private String color;
}
