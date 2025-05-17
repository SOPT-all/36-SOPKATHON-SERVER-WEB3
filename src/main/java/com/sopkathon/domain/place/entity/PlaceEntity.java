package com.sopkathon.domain.place.entity;

import com.sopkathon.domain.subway.entity.SubwayEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "place")
public class PlaceEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "duration", nullable = false)
	private int duration;

	@Column(name = "description", nullable = false)
	private String description;

	@Column(name = "map_link", nullable = false)
	private String mapLink;

	@Column(name = "photo_url", nullable = false)
	private String photoUrl;

	@Enumerated(EnumType.STRING)
	@Column(name = "category", nullable = false)
	private Category category;

	@ManyToOne(targetEntity = SubwayEntity.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "subway_id", nullable = false)
	private SubwayEntity subwayEntity;

	@Builder
	public PlaceEntity(int duration, String description, String mapLink, String photoUrl, Category category,
		SubwayEntity subwayEntity) {
		this.duration = duration;
		this.description = description;
		this.mapLink = mapLink;
		this.photoUrl = photoUrl;
		this.category = category;
		this.subwayEntity = subwayEntity;
	}
}
