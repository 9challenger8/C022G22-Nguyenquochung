package com.sprint2_api.rest_controller;


import com.sprint2_api.model.BookOrder;
import com.sprint2_api.service.IBookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/public/bookOrder")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookOrderRestController {

    @Autowired
    private IBookOrderService iBookOrderService;

    @PostMapping("/create")
    public ResponseEntity<BookOrder> createBookOrder(@RequestBody BookOrder bookOrder) {
        iBookOrderService.save(bookOrder);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
