package com.sopkathon.domain.place.dto;

import java.util.List;

public record GetPlaceDetailRes(
        Long placeId,
        String name,
        String address,
        String recruitDate,
        String startedAt,
        String endAt,
        int duration,
        String description,
        String mapLink,
        String photoUrl,
        int price,
        List<ReviewDto> reviewList
) {
}
