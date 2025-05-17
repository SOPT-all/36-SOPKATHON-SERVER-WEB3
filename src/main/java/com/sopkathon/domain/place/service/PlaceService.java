package com.sopkathon.domain.place.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sopkathon.domain.place.dto.GetPlaceListResponse;
import com.sopkathon.domain.place.dto.GetPlaceResponse;
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
}
