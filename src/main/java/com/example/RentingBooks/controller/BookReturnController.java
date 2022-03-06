package com.example.RentingBooks.controller;

import com.example.RentingBooks.dto.BookTransactionDto;
import com.example.RentingBooks.service.BookTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@Controller
@RequestMapping("/books_return")

public class BookReturnController {
    @Autowired
    private BookTransactionService bookTransactionService;
    @GetMapping
    public String openbooktransaction(Model model){
        model.addAttribute("bookReturnDto",new BookTransactionDto());
       model.addAttribute("bookReturnDtoList",bookTransactionService.findAll());
        return "/book_transaction/book_return";
    }
    @GetMapping("/delete/{id}")
    public String deleteBookTransaction(@PathVariable("id") Integer id, Model model){
        bookTransactionService.deleteById(id);
        return "redirect:/books_return";

    }
    @GetMapping("/book_return_view/{id}")
    public String viewBookReturn(@PathVariable("id") Integer id,Model model) {
        model.addAttribute("bookReturnDtos",bookTransactionService.findById(id));



        return "/book_transaction/book_return_view";
    }

    @GetMapping(value="/create/{id}")
    public String createReturn(@ModelAttribute BookTransactionDto bookTransactionDto,@PathVariable("id") Integer id,Model model){
        bookTransactionDto=bookTransactionService.findById(id);
        bookTransactionService.create(bookTransactionDto);

        return "redirect:/books_return";
    }



}
