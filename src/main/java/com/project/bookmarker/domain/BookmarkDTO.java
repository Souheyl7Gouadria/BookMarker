package com.project.bookmarker.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookmarkDTO {

    private Long id;
    private String title;
    private String url;
    private Instant createdAt;
}
