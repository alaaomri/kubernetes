package com.test.kubernetes.service;

import com.test.kubernetes.domain.Bookmark;
import com.test.kubernetes.dto.PageableDTO;
import com.test.kubernetes.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Transactional(readOnly = true)
    public PageableDTO<Bookmark> getAllBookmarks(int page) {
        int pageNumber = page < 1 ? 0 : page-1;
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.Direction.ASC, "createdAt");

        return new PageableDTO<>(bookmarkRepository.findAll(pageable));
    }
}
