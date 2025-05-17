package com.sopkathon.domain.place.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sopkathon.domain.place.dto.GetPlaceListResponse;
import com.sopkathon.domain.place.service.PlaceService;
import com.sopkathon.global.error.code.SuccessCode;
import com.sopkathon.global.error.dto.SuccessResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/places")
public class PlaceController {
	private final PlaceService placeService;

	@GetMapping
	public ResponseEntity<SuccessResponse<?>> getPlaceList(@RequestParam(name = "category", defaultValue = "ALL") String category,
		@RequestParam(name = "subway") String subway){
		GetPlaceListResponse getPlaceListResponse = placeService.getPlaceList(category, subway);
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, getPlaceListResponse));
	}
}
