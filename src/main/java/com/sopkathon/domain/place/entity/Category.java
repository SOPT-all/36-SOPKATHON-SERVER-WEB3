package com.sopkathon.domain.place.entity;

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

	private String name;

	Category(String name) {}

	public static Category fromName(String name) {
		for (Category category : values()) {
			if(category.name.equals(name)) {
				return category;
			}
		}
		throw new BusinessException(ErrorCode.DATA_NOT_FOUND);
	}
}
