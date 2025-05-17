package com.sopkathon.domain.place.dto;

import java.util.List;

public record GetPlaceListResponse(
	List<GetPlaceResponse> getPlaceResponseList
) {
	public static GetPlaceListResponse of(List<GetPlaceResponse> getPlaceResponseList) {
		return new GetPlaceListResponse(getPlaceResponseList);
	}
}
