package com.sopkathon.domain.place.controller;

import com.sopkathon.domain.place.dto.GetPlaceDetailRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
														   @RequestParam(name = "subway") String subway) {
		GetPlaceListResponse getPlaceListResponse = placeService.getPlaceList(category, subway);
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, getPlaceListResponse));
	}

	@GetMapping("/{place-id}")
	public ResponseEntity<SuccessResponse<?>> getPlaceDetailById(@PathVariable("place-id") Long placeId) {
		GetPlaceDetailRes getPlaceDetailRes = placeService.getPlaceDetailById(placeId);
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_GET_PLACE_DETAIL, getPlaceDetailRes));
	};
}
