package com.example.RentingBooks.controller;

import com.example.RentingBooks.dto.AuthorDto;
import com.example.RentingBooks.dto.BookDto;
import com.example.RentingBooks.dto.CategoryDto;
import com.example.RentingBooks.service.AuthorService;
import com.example.RentingBooks.service.BookService;
import com.example.RentingBooks.service.CategoryService;
import com.example.RentingBooks.service.ExcelGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;
    @Autowired
    private ExcelGenerationService excelGenerationService;
    @GetMapping
    public String openbook(Model model){
        List<CategoryDto> categories=categoryService.findAll();
        List<AuthorDto> authors=authorService.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("authors",authors);
        model.addAttribute("bookDto",new BookDto());
        model.addAttribute("bookDtoList",bookService.findAll());
        return "/books/books";
    }
    @PostMapping("create")
    public String createBook(@ModelAttribute BookDto bookDto, RedirectAttributes redirectAttributes){
        bookDto=bookService.create(bookDto);
        if(bookDto!=null){
            redirectAttributes.addFlashAttribute("message","Data Saved Successfully");
        }else{
            redirectAttributes.addFlashAttribute("message","Data not Saved");
        }

        return "redirect:/books";
    }
    @PostMapping("generate")
    public String generateExcel(Model model) throws IOException {
        excelGenerationService.generateExcel();
        model.addAttribute("message","Generated Successfully");
        return "redirect:/books";
    }
    @GetMapping("/view/{id}")
    public String viewBook(@PathVariable("id") Integer id,Model model) throws IOException {
    model.addAttribute("bookdto",bookService.findById(id));
            return "/books/view";
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id,Model model){
        bookService.deleteById(id);
        return "redirect:/books";

    }

}
