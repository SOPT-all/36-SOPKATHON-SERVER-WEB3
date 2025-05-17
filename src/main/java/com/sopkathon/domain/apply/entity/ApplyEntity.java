package com.sopkathon.domain.apply.entity;

import com.sopkathon.domain.place.entity.PlaceEntity;
import com.sopkathon.domain.user.UserEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ApplyEntity {
	@Id
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	private ApplyStatus status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "place_id", nullable = false)
	private PlaceEntity place;

	@Builder
	public ApplyEntity(ApplyStatus status, PlaceEntity place) {
		this.status = status;
		this.place = place;
	}
}
