package com.sopkathon.domain.place.service;

import java.util.List;

import com.sopkathon.domain.place.dto.*;
import com.sopkathon.domain.review.entity.ReviewEntity;
import com.sopkathon.domain.review.repository.ReviewRepository;
import com.sopkathon.global.error.code.ErrorCode;
import com.sopkathon.global.error.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.sopkathon.domain.place.entity.Category;
import com.sopkathon.domain.place.entity.PlaceEntity;
import com.sopkathon.domain.place.repository.PlaceRepository;
import com.sopkathon.domain.subway.entity.SubwayEntity;
import com.sopkathon.domain.subway.service.SubwayService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceService {
	private final PlaceRepository placeRepository;
	private final ReviewRepository reviewRepository;
	private final SubwayService SubwayService;

	public GetPlaceListResponse getPlaceList(String category, String subway){
		SubwayEntity subwayEntity = SubwayService.getSubwayEntity(subway);
		List<PlaceEntity> placeEntityList = getPlacesByCategory(subwayEntity, category);

		List<GetPlaceResponse> getPlaceResponseList = placeEntityList.stream()
			.map(GetPlaceResponse::of)
			.toList();

		return new GetPlaceListResponse(getPlaceResponseList);
	}

	private List<PlaceEntity> getPlacesByCategory(SubwayEntity subwayEntity, String category) {
		if ("ALL".equals(category)) {
			return placeRepository.findAllBySubwayEntity(subwayEntity);
		}
		return placeRepository.findAllBySubwayEntityAndCategory(subwayEntity, Category.fromKorName(category));
	}

	public GetPlaceDetailRes getPlaceDetailById(Long placeId) {
		PlaceEntity place = placeRepository.findById(placeId)
				.orElseThrow(() -> new BusinessException(ErrorCode.PLACE_NOT_FOUND));

		List<ReviewEntity> reviews = reviewRepository.findByPlaceEntity_Id(placeId);

		List<ReviewDto> reviewDtos = reviews.stream()
				.map(ReviewDto::from)
				.toList();

		return new GetPlaceDetailRes(
				place.getId(),
				place.getName(),
				place.getLocation(),
				place.getDate(),
				place.getStartedAt(),
				place.getEndAt(),
				place.getDuration(),
				place.getDescription(),
				place.getMapLink(),
				place.getPhotoUrl(),
				place.getPrice(),
				reviewDtos
		);
	}
}
