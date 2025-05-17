package com.sopkathon.domain.place.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopkathon.domain.place.entity.Category;
import com.sopkathon.domain.place.entity.PlaceEntity;
import com.sopkathon.domain.subway.entity.SubwayEntity;

@Repository
public interface PlaceRepository extends JpaRepository<PlaceEntity,Long> {
	List<PlaceEntity> findAllBySubwayEntity(SubwayEntity subwayEntity);
	List<PlaceEntity> findAllBySubwayEntityAndCategory(SubwayEntity subwayEntity, Category category);
}
