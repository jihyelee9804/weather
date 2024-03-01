package zerobase.wether.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zerobase.wether.service.DiaryService;

import java.time.LocalDate;

@RestController // 응답 상태코드를 컨트롤러에서 지정할 수 있다.
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    // 날씨 일기 작성하는 api
    @PostMapping("/create/diary")
    void createDiary(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date,
                     @RequestBody String text) { // 일기 내용, 날짜 값을 받는다.
        diaryService.createDiary(date, text);
    }
}
