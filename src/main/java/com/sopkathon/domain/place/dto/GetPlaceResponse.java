package com.sopkathon.domain.place.dto;


import com.sopkathon.domain.place.entity.PlaceEntity;

import lombok.Builder;

@Builder
public record GetPlaceResponse(
	Long placeId,
	String name,
	String description,
	int price,
	String farmer,
	String photoUrl
) {

	public static GetPlaceResponse of(PlaceEntity placeEntity) {
		return GetPlaceResponse.builder()
			.placeId(placeEntity.getId())
			.name(placeEntity.getName())
			.description(placeEntity.getDescription())
			.photoUrl(placeEntity.getPhotoUrl())
			.price(placeEntity.getPrice())
			.farmer(placeEntity.getFarmer())
			.build();
	}
}
