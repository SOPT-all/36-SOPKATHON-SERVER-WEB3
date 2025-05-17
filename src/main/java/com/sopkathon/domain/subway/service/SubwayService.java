package com.sopkathon.domain.subway.service;

import com.sopkathon.domain.subway.dto.SubwayListRes;
import com.sopkathon.domain.subway.entity.SubwayEntity;
import com.sopkathon.domain.subway.repository.SubwayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class SubwayService {
    private final SubwayRepository subwayRepository;

    @Transactional(readOnly = true)
    public SubwayListRes getSubwayList() {
        List<String> subwayList = subwayRepository.findAll()
                .stream()
                .map(SubwayEntity::getSubwayName)
                .collect(Collectors.toList());

        return SubwayListRes.from(subwayList);
    }

    @Transactional(readOnly = true)
    public SubwayListRes getSubwayListByKeyword(String keyword) {
        List<String> subwayList = subwayRepository.findBySubwayNameContaining(keyword)
                .stream()
                .map(SubwayEntity::getSubwayName)
                .collect(Collectors.toList());

        return SubwayListRes.from(subwayList);
    }

    public SubwayEntity getSubwayEntity(String subwayName) {
        return subwayRepository.findBySubwayName(subwayName);
    }

    public SubwayEntity getSubwayEntity(String subwayName) {
        return subwayRepository.findBySubwayName(subwayName);
    }
}
