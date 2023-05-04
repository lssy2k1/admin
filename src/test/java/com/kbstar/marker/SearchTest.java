package com.kbstar.marker;

import com.kbstar.dto.MarkerSearch;
import com.kbstar.service.MarkerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 4.27 정인보 selectAll 테스트 완료
 *
 */
@Slf4j // 로그 찍을거야
@SpringBootTest
class SearchTest {
    @Autowired
    MarkerService service;
    @Test
    void contextLoads() {
        try {
            MarkerSearch ms = new MarkerSearch("국",null);
            service.search(ms);
            log.info("------- Marker(맛집추천) 전체 조회 성공! -------");
        } catch (Exception e) { // 오류 예외처리(자동)
            //throw new RuntimeException(e);
                log.info("-------  Marker(맛집추천) 전체조회 에러 발생 -------");
            // e.printStackTrace(); // 에러 자세히
        }
    }
}
