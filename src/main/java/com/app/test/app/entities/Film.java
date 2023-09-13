package com.app.test.app.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="movies")
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name="rating")
    private float rating;
    @Column(name = "image")
    private String image;

}
