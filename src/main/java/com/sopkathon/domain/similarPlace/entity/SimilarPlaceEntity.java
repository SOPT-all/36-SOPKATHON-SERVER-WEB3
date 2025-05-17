package com.sopkathon.domain.similarPlace.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "similar_place")
public class SimilarPlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "duration")
    private String duration;

    @Column(name = "description")
    private String description;

    @Column(name = "photoUrl")
    private String photoUrl;

    public SimilarPlaceEntity(String duration, String description, String photoUrl) {
        this.duration = duration;
        this.description = description;
        this.photoUrl = photoUrl;
    }

}
