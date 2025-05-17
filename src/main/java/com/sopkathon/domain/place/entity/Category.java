package com.sopkathon.domain.place.entity;

import java.util.Arrays;

import com.sopkathon.global.error.code.ErrorCode;
import com.sopkathon.global.error.exception.BusinessException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public enum Category {
	ORCHARD("과수원"),
	CROPS("밭작물"),
	LIVESTOCK("축산"),
	PLANTS_AND_FLOWERS("식물·꽃"),
	OTHER("기타");

	private String korName;

	Category(String korName) {
		this.korName = korName;
	}


	public String getKorName() {
		return korName;
	}

	public static Category fromKorName(String korName) {
		return Arrays.stream(Category.values())
			.filter(c -> c.korName.equals(korName))
			.findFirst()
			.orElseThrow(() -> new IllegalArgumentException("Unknown category: " + korName));
	}
}
