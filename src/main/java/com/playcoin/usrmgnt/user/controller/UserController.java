package com.playcoin.usrmgnt.user.controller;

import com.playcoin.usrmgnt.user.domain.User;
import com.playcoin.usrmgnt.user.domain.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String index(Model model) {

        List<User> users = userRepository.findAll();

        model.addAttribute("users", users);
        model.addAttribute(new User());

        return "index";
    }

    @PostMapping(value = "/")
    public String save(@Valid @ModelAttribute User user,
                       BindingResult bindingResult,
                       Model model) {

        if (bindingResult.hasErrors()) {

            model.addAttribute("users", userRepository.findAll());
            model.addAttribute(bindingResult.getAllErrors());

            return "index";
        }
            userRepository.save(user);
            return "redirect:/";
    }

    @GetMapping("/detail/{id}")
    public String detail(@PathVariable Long id, Model model)
    {
        User users = userRepository.findById(id).get();

        model.addAttribute("users", users);

        return "detail-view";
    }
}