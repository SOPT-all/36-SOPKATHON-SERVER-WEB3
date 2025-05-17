package com.sopkathon.domain.subway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopkathon.domain.subway.entity.SubwayEntity;

import java.util.List;

@Repository
public interface SubwayRepository extends JpaRepository<SubwayEntity, Long> {
    List<SubwayEntity> findBySubwayNameContaining(String keyword);
	SubwayEntity findBySubwayName(String subwayName);
}
