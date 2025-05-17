package com.sopkathon.domain.review.repository;

import com.sopkathon.domain.review.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    List<ReviewEntity> findByPlaceEntity_Id(Long placeId);
}
