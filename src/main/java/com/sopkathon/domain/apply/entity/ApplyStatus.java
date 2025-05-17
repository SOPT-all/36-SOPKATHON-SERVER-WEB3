package com.sopkathon.domain.apply.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public enum ApplyStatus {
	PENDING,
	APPROVED
}
