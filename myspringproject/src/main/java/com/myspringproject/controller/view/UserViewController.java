package com.myspringproject.controller.view;

import com.myspringproject.dto.user.LoginCommand;
import com.myspringproject.dto.user.RegistrationRequest;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.dto.user.UserSearchRequest;
import com.myspringproject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/userss")
@RequiredArgsConstructor
public class UserViewController {

    private final UserService userService;

    @ModelAttribute("searchCommand")
    public UserSearchRequest userSearchCommand() {
        return new UserSearchRequest();
    }


    @GetMapping
    public String findAll(Model model) {

        Collection<UserResponseDto> users = userService.findAllActiveUsers();

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
    public String crate(@ModelAttribute RegistrationRequest userRegistrationCommand) {

        return "redirect:/users/" + userService.create(userRegistrationCommand);
    }

    @DeleteMapping("/{username}")
    public String delete(@PathVariable("username") String username) {

        userService.deleteByUsername(username);

        return "redirect:/users";
    }

    @GetMapping("/search")
    public String searchUsers(@ModelAttribute @Valid UserSearchRequest command, Model model) {
        Collection<UserResponseDto> searchResults = userService.search(command);
        model.addAttribute("searchResults", searchResults);
        return "search";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginCommand", new LoginCommand());
        return "login";
    }
}
