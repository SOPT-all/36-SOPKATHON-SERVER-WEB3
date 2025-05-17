package com.sopkathon.domain.apply.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sopkathon.domain.apply.dto.GetApplyListResponse;
import com.sopkathon.domain.apply.dto.GetApplyResponse;
import com.sopkathon.domain.apply.entity.ApplyEntity;
import com.sopkathon.domain.apply.entity.ApplyStatus;
import com.sopkathon.domain.apply.repository.ApplyRepository;
import com.sopkathon.domain.place.dto.GetPlaceResponse;
import com.sopkathon.domain.place.entity.PlaceEntity;
import com.sopkathon.domain.place.repository.PlaceRepository;
import com.sopkathon.domain.user.UserEntity;
import com.sopkathon.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ApplyService {

	private final ApplyRepository applyRepository;
	private final PlaceRepository placeRepository;
	private final UserRepository userRepository;

	// 신청 생성
	public void addApply(Long placeId) {
		// 임시: 로그인된 유저 ID 하드코딩 (나중에 인증 붙이면 수정)
		Long userId = 1L;

		PlaceEntity place = placeRepository.findById(placeId)
			.orElseThrow(() -> new IllegalArgumentException("장소를 찾을 수 없습니다."));

		ApplyEntity apply = ApplyEntity.builder()
			.status(ApplyStatus.PENDING)
			.place(place)
			.build();

		applyRepository.save(apply);
	}

	// 신청 목록 조회
	public List<GetPlaceResponse> getApplyList(String status) {
		ApplyStatus applyStatus = ApplyStatus.valueOf(status.toUpperCase());
		List<ApplyEntity> applies = applyRepository.findByStatus(applyStatus);

		return applies.stream()
			.map(apply -> {
				PlaceEntity place = apply.getPlace();
				return  GetPlaceResponse.of(place);
			})
			.toList();

	}
}
