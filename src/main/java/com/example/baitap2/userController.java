package com.example.baitap2;

import com.example.baitap2.UserModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
    public class userController {

    @GetMapping("/user")
    public String trangChiTiet(Model model) {
        model.addAttribute("userName", "Nguyen Van A");
        return "user";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new UserModel());
        return "addUser";
    }

    @PostMapping("/addUser")
    public String saveUser(@ModelAttribute("user")UserModel user) {
        System.out.println("firstName: " + user.getFirstName());
        System.out.println("lastName: " + user.getLastName());
        return "redirect:/user";
    }
}