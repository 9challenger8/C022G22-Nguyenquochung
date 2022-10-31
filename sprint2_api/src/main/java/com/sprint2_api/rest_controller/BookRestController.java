package com.sprint2_api.rest_controller;

import com.sprint2_api.model.Book;
import com.sprint2_api.service.IBookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/public/book")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookRestController {

    private final IBookService iBookService;

    public BookRestController(IBookService iBookService) {
        this.iBookService = iBookService;
    }

    @GetMapping("/list")
    public ResponseEntity<Page<Book>> getBookAndSearch(@PageableDefault(value = 12) Pageable pageable,
                                                       @RequestParam Optional<String> name){
        String keywordName = name.orElse("");
        Page<Book> bookPage = iBookService.getBookAndSearch(keywordName,pageable);
        return new ResponseEntity<>(bookPage, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id){
        return new ResponseEntity<>(iBookService.findBookById(id),HttpStatus.OK);
    }
}
