package com.sopkathon.domain.subway.dto;

import com.sopkathon.domain.subway.entity.SubwayEntity;

import java.util.List;

public record SubwayListRes(
        List<String> subways
) {
    public static SubwayListRes from(List<String> subways) {
        return new SubwayListRes(subways);
    }
}
