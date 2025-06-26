package com.green.memoserver;

import com.green.memoserver.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
// 공통 URL
@RequestMapping("api/memo")
public class MemoController {
    private final MemoService memoService;

    // C
    // (post) /api/memo
    @PostMapping
    public String postMemo (@RequestBody MemoPostReq req) {
        log.info("req={}", req);
        int result = memoService.save(req);
        return result == 1 ? "저장 성공": "저장 실패";

    }

    // R
    @GetMapping
    public List<MemoGetRes> getMemo(@ModelAttribute MemoGetReq req) {
        log.info("req={}", req);
        return memoService.findAll(req);
    }
//    public String getMemo(@ModelAttribute MemogetReg reg {

    @GetMapping("/{memoId}")
    public MemoGetOneRes getMemoOne(@PathVariable int memoId) {
        log.info("memoId={}", memoId);
        return memoService.findById(memoId);
    }

    // U
    @PutMapping
    public String putMemo(@RequestBody MemoPutReq req) {
        log.info("req={}", req);
        return "수정 완료";
    }

    // D
    @DeleteMapping
    public String deleteMemo(@RequestParam(name="memo_id") int memoId) {
        log.info("memoId={}", memoId);
        int result = memoService.deleteById(memoId);
        return result == 1 ? "삭제 성공":"삭제 실패";
    }
}
