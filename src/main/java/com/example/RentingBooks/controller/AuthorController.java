package com.example.RentingBooks.controller;

import com.example.RentingBooks.dto.AuthorDto;
import com.example.RentingBooks.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping
    public String openauthor(Model model){
        model.addAttribute("authorDto",new AuthorDto());
        model.addAttribute("authorDtoList",authorService.findAll());
        return "/author/author";
    }
    @PostMapping("create")
    public String createAuthor(@ModelAttribute AuthorDto authorDto, RedirectAttributes redirectAttributes){
        authorDto=authorService.create(authorDto);
        authorService.sendEmail(authorDto);
        if(authorDto!=null){
            redirectAttributes.addFlashAttribute("message","Data Saved Successfully");
        }else{
            redirectAttributes.addFlashAttribute("message","Data not Saved");
        }

        return "redirect:/author";
    }

}
