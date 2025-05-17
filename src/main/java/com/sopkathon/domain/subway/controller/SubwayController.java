package com.sopkathon.domain.subway.controller;

import com.sopkathon.domain.subway.dto.SubwayListRes;
import com.sopkathon.domain.subway.service.SubwayService;
import com.sopkathon.global.error.code.SuccessCode;
import com.sopkathon.global.error.dto.SuccessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SubwayController {
    private final SubwayService subwayService;

    public SubwayController(SubwayService subwayService) {
        this.subwayService = subwayService;
    }

    @GetMapping("/subways")
    public ResponseEntity<SuccessResponse<SubwayListRes>> getSubwayList() {
        SubwayListRes subwayListRes = subwayService.getSubwayList();

        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_SUBWAY_LIST, subwayListRes));
    }

    @GetMapping("/subways/search")
    public ResponseEntity<SuccessResponse<SubwayListRes>> getSubwayListByKeyword(@RequestParam(name = "keyword") String keyword) {
        SubwayListRes subwayListRes = subwayService.getSubwayListByKeyword(keyword);

        return ResponseEntity.ok(SuccessResponse.of(SuccessCode.SUCCESS_SUBWAY_LIST, subwayListRes));
    }
}
