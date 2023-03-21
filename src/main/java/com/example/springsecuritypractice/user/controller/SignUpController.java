package com.example.springsecuritypractice.user.controller;

import com.example.springsecuritypractice.user.dto.UserRegisterDto;
import com.example.springsecuritypractice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignUpController {
    private final UserService userService;

    /*
    @return 회원가입 페이지 리소스
     */
    @GetMapping
    public String signup(){return "signup";}

    @PostMapping
    public String signup(
            @ModelAttribute UserRegisterDto userDto
    ){
        userService.signup(userDto.getUsername(), userDto.getPassword());
        // 로그인 페이지로 이동
        return "redirect:login";
    }
}
