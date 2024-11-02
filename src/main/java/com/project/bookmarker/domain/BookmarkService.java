package com.project.bookmarker.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
//all meth will be transactional,either completed or rolled back
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository repository;
    private final BookmarkMapper bookmarkMapper;

    @Transactional(readOnly = true)//hibernate will optimize performance
    public BookmarksDTO getBookmarks(Integer page){
        int pageNumber = page < 1 ? 0 : page-1; // in jpa page numbers start with 0
        Pageable pageable = PageRequest.of(pageNumber, 10, Sort.by(Sort.Direction.DESC, "createdAt"));
        //when loading the data,using DTO projection, will not keep track of the changes on the entity
        //and will optimize the db querying performance,by extracting only the dto fields
        Page<BookmarkDTO> bookmarkPage = repository.findBookmarks(pageable);


        //Page<BookmarkDTO> bookmarkPage = repository.findAll(pageable).map(bookmarkMapper::toDTO);
        return new BookmarksDTO(bookmarkPage);
    }
}
