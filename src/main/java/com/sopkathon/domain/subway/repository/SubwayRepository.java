package com.sopkathon.domain.subway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopkathon.domain.subway.entity.SubwayEntity;

@Repository
public interface SubwayRepository extends JpaRepository<SubwayEntity, Long> {
	SubwayEntity findBySubwayName(String subwayName);
}
