package com.betek.interactivetInnovationEducation.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostEntity {

    // Remember, when using collections like ArrayList in JPA entities, you might need to properly
    // manage these collections by initializing them correctly, handling null values,
    // and taking care of cascade operations based on your business logic and database setup.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500)
    private ArrayList<String> media;
    @Column(length = 100)
    private String caption;
    @Column(length = 800)
    private String description;
    private ArrayList<Long> likes;
    private ArrayList<Long> comments;
    private Long country;
    private Long topic;
    private LocalDate created_at;
    @Column(name = "idUser")
    private Long idUser;
}
