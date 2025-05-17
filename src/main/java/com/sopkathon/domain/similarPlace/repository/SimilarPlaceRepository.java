package com.sopkathon.domain.similarPlace.repository;

import com.sopkathon.domain.similarPlace.entity.SimilarPlaceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimilarPlaceRepository extends JpaRepository<SimilarPlaceEntity, Long> {
}
