package com.example.RentingBooks.controller;

import com.example.RentingBooks.dto.AuthorDto;
import com.example.RentingBooks.dto.MemberDto;
import com.example.RentingBooks.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @GetMapping
    public String openmember(Model model){
        model.addAttribute("memberDto",new MemberDto());
        model.addAttribute("memberDtoList",memberService.findAll());
        return "/member/member";
    }
    @PostMapping("create")
    public String createMember(@ModelAttribute MemberDto memberDto, RedirectAttributes redirectAttributes){
        memberDto=memberService.create(memberDto);
        if(memberDto!=null){
            redirectAttributes.addFlashAttribute("message","Data Saved Successfully");
        }else{
            redirectAttributes.addFlashAttribute("message","Data not Saved");
        }

        return "redirect:/member";
    }
    @GetMapping("/delete/{id}")
    public String deleteAuthor(@PathVariable("id") Integer id, Model model){
        memberService.deleteById(id);
        return "redirect:/member";

    }
}
