package com.test.kubernetes.controller;

import com.test.kubernetes.domain.Bookmark;
import com.test.kubernetes.dto.PageableDTO;
import com.test.kubernetes.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping
    public PageableDTO<Bookmark> getAllBookmarks(@RequestParam(name = "page", defaultValue = "1") int page) {
        return bookmarkService.getAllBookmarks(page);
    }


}
