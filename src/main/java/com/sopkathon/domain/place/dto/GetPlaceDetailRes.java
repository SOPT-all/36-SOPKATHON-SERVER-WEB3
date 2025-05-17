package com.sopkathon.domain.place.dto;

public record GetPlaceDetailRes(
        Long placeId,
        String name,
        String address,
        String recruitDate,
        String startedAt,
        String endAt,
        String duration,
        String description,
        String mapLink,
        String photoUrl,
        int price,
        ReviewListDto reviewList
) {
}
