package com.sopkathon.domain.apply.dto;

public record GetApplyResponse(
	Long placeId,
	String name,
	String description,
	int price,
	String farmer,
	String photoUrl
) {

}
