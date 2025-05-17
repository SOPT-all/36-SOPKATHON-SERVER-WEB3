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

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "photoUrl", nullable = false)
    private String photoUrl;
}
