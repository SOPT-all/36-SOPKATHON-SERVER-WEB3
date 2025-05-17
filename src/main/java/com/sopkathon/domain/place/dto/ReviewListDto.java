package com.sopkathon.domain.place.dto;

import com.sopkathon.domain.review.entity.ReviewEntity;

import java.util.List;

public record ReviewListDto(
        List<ReviewEntity> reviews
) {
    public static ReviewListDto from(List<ReviewEntity> reviews) {
        return new ReviewListDto(reviews);
    }
}