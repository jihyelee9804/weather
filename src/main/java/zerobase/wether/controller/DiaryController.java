package zerobase.wether.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import zerobase.wether.domain.Diary;
import zerobase.wether.service.DiaryService;

import java.time.LocalDate;
import java.util.List;

@RestController // 응답 상태코드를 컨트롤러에서 지정할 수 있다.
public class DiaryController {

    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    // 일기 작성
    @PostMapping("/create/diary")
    void createDiary(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date,
                     @RequestBody String text) { // 일기 내용, 날짜 값을 받는다.
        diaryService.createDiary(date, text);
    }

    // 일기 조회
    @GetMapping("/read/diary")
    List<Diary> readDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return diaryService.readDiary(date);
    }

    // 특정 기간동안 일기 조회
    @GetMapping("/read/diaries")
    List<Diary> readDiaries(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {
        return diaryService.readDiaries(startDate, endDate);
    }

    // 일기 수정
    @GetMapping("/update/diary")
    void updateDiary(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
                     @RequestBody String text) {
        diaryService.updateDiary(date, text);
    }

    // 일기 삭제
    @DeleteMapping("/delete/diary")
    void delete(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        diaryService.deleteDiary(date);
    }
}
