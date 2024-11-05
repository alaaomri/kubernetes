package com.test.kubernetes;

import com.test.kubernetes.domain.Bookmark;
import com.test.kubernetes.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final BookmarkRepository bookmarkRepository;

    @Override
    public void run(String... args) throws Exception {
        bookmarkRepository.save(new Bookmark(null, "Sivalabs","http://bookmark.com/1", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Google","http://bookmark.com/2", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Yahoo","http://bookmark.com/3", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Bing","http://bookmark.com/4", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Facebook","http://bookmark.com/5", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Twitter","http://bookmark.com/6", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "LinkedIn","http://bookmark.com/7", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Github","http://bookmark.com/8", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Gitlab","http://bookmark.com/9", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Bitbucket","http://bookmark.com/10", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "AWS","http://bookmark.com/11", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Azure","http://bookmark.com/12", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "GCP","http://bookmark.com/13", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Heroku","http://bookmark.com/14", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Netlify","http://bookmark.com/15", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Vercel","http://bookmark.com/16", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "DigitalOcean","http://bookmark.com/17", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Linode","http://bookmark.com/18", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "Vultr","http://bookmark.com/19", Instant.now()));
        bookmarkRepository.save(new Bookmark(null, "UpCloud","http://bookmark.com/20", Instant.now()));

    }
}
