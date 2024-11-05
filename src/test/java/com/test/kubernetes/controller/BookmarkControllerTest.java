package com.test.kubernetes.controller;


import com.test.kubernetes.TestContainersConfig;
import com.test.kubernetes.domain.Bookmark;
import com.test.kubernetes.repository.BookmarkRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testcontainers.shaded.org.hamcrest.CoreMatchers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebMvc
@Import(TestContainersConfig.class)
public class BookmarkControllerTest {


    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private BookmarkRepository bookmarkRepository;

    @BeforeEach
    public void setup() {
        this.mockMvc = webAppContextSetup(this.wac).build();
        bookmarkRepository.deleteAllInBatch();
        List<Bookmark> bookmarks = new ArrayList<>();

        bookmarks.add(new Bookmark(null, "Sivalabs","http://bookmark.com/1", Instant.now()));
        bookmarks.add(new Bookmark(null, "Google","http://bookmark.com/2", Instant.now()));
        bookmarks.add(new Bookmark(null, "Yahoo","http://bookmark.com/3", Instant.now()));
        bookmarks.add(new Bookmark(null, "Bing","http://bookmark.com/4", Instant.now()));
        bookmarks.add(new Bookmark(null, "Facebook","http://bookmark.com/5", Instant.now()));
        bookmarks.add(new Bookmark(null, "Twitter","http://bookmark.com/6", Instant.now()));
        bookmarks.add(new Bookmark(null, "LinkedIn","http://bookmark.com/7", Instant.now()));
        bookmarks.add(new Bookmark(null, "Github","http://bookmark.com/8", Instant.now()));
        bookmarks.add(new Bookmark(null, "Gitlab","http://bookmark.com/9", Instant.now()));
        bookmarks.add(new Bookmark(null, "Bitbucket","http://bookmark.com/10", Instant.now()));

        bookmarkRepository.saveAll(bookmarks);
    }


    @ParameterizedTest
    @CsvSource({
            "1","2"
    })
    void testGetBookmarks(int page) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/bookmarks?page="+page))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.totalElements").value(10));
    }

}
