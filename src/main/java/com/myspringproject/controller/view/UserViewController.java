package com.myspringproject.controller.view;

import com.myspringproject.dto.user.UserRegistrationCommand;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserViewController {

    private final UserService userService;


    @GetMapping
    public String findAll(Model model) {

        List<UserResponseDto> users = userService.findAllActiveUsers();

        model.addAttribute("users", users);

        return "user/users";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") Long id, Model model) {

        model.addAttribute("user", userService.findById(id));

        return "user/user";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String crate(@ModelAttribute UserRegistrationCommand userRegistrationCommand) {

        return "redirect:/users/" + userService.create(userRegistrationCommand);
    }

//    @PostMapping("/{id}/update")
//    public String update(@PathVariable("id") Long id, @ModelAttribute UserUpdateDto user) {
//        return userService.update(id, user)
//                .map(it -> "redirect:/users/{id}")
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
//    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {

        userService.deleteById(id);

        return "redirect:/users";
    }
}
