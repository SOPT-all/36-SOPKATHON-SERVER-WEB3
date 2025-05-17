package com.sopkathon.domain.place.dto;

import com.sopkathon.domain.review.entity.ReviewEntity;

public record ReviewDto(
        String author,
        String date,
        String content,
        String profileImageUrl
) {
    public static ReviewDto from(ReviewEntity entity) {
        return new ReviewDto(
                entity.getAuthor(),
                entity.getCreatedAt(),
                entity.getContent(),
                entity.getProfileImageUrl()
        );
    }
}
