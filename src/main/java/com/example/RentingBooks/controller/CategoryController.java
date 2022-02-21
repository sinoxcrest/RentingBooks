package com.example.RentingBooks.controller;

import com.example.RentingBooks.dto.CategoryDto;
import com.example.RentingBooks.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/category")
public class CategoryController {
  @Autowired
  private CategoryService categoryService;

    @GetMapping
    public String opencategory(Model model){
        model.addAttribute("categoryDto",new CategoryDto());
        model.addAttribute("categoryDtoList",categoryService.findAll());
        return "/category/category";
    }
    @PostMapping("create")
    public String createCategory(@ModelAttribute CategoryDto categoryDto, RedirectAttributes redirectAttributes){
        categoryDto=categoryService.create(categoryDto);
        if(categoryDto!=null){
            redirectAttributes.addFlashAttribute("message","Data Saved Successfully");
        }else{
            redirectAttributes.addFlashAttribute("message","Data not Saved");
        }

        return "redirect:/category";
    }
}
