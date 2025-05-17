package com.sopkathon.domain.place.entity;

import com.sopkathon.global.error.code.ErrorCode;
import com.sopkathon.global.error.exception.BusinessException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public enum Category {
	NATURAL("자연");

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
