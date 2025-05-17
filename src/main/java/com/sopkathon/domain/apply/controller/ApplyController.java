package com.sopkathon.domain.apply.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sopkathon.domain.apply.dto.GetApplyListResponse;
import com.sopkathon.domain.apply.dto.GetApplyResponse;
import com.sopkathon.domain.apply.entity.ApplyEntity;
import com.sopkathon.domain.apply.service.ApplyService;
import com.sopkathon.domain.place.dto.GetPlaceListResponse;
import com.sopkathon.domain.place.dto.GetPlaceResponse;
import com.sopkathon.global.error.code.SuccessCode;
import com.sopkathon.global.error.dto.SuccessResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/apply")
public class ApplyController {
	private final ApplyService applyService;

	@PostMapping("/{place-id}")
	public ResponseEntity<SuccessResponse<?>> apply(@PathVariable("place-id") Long placeId) {
		applyService.addApply(placeId);
		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_CREATE));
	}

	@GetMapping("/list")
	public ResponseEntity<SuccessResponse<?>> getApplies(@RequestParam(defaultValue = "PENDING") String status) {
		GetPlaceListResponse getPlaceListResponse = GetPlaceListResponse.of(applyService.getApplyList(status));

		return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_FETCH, getPlaceListResponse));
	}
}
