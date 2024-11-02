package com.project.bookmarker;

import com.project.bookmarker.domain.Bookmark;
import com.project.bookmarker.domain.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {
    private final BookmarkRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Bookmark(null,"springBlog","https://spring.io/blog", Instant.now()));
    }
}
