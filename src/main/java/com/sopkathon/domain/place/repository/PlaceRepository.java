package com.sopkathon.domain.place.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopkathon.domain.place.entity.PlaceEntity;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity,Long> {
}
