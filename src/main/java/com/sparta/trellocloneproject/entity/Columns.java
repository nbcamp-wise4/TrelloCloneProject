package com.sparta.trellocloneproject.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name ="columns")
public class Columns {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long ID;
    @Column
    private String title;
    @Column
    private int position;



}
