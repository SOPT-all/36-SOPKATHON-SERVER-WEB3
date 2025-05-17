package com.sopkathon.domain.apply.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sopkathon.domain.apply.entity.ApplyEntity;
import com.sopkathon.domain.apply.entity.ApplyStatus;

@Repository
public interface ApplyRepository extends JpaRepository<ApplyEntity, Long> {
	List<ApplyEntity> findByStatus(ApplyStatus applyStatus);

}
