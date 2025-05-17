package com.sopkathon.domain.place.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {
	@Override
	public String convertToDatabaseColumn(Category attribute) {
		return attribute.getKorName(); // 한글로 저장
	}

	@Override
	public Category convertToEntityAttribute(String dbData) {
		return Category.fromKorName(dbData); // 한글 → Enum으로 복원
	}
}
