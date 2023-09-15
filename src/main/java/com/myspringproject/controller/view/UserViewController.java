package com.myspringproject.controller.view;

import com.myspringproject.dto.user.LoginCommand;
import com.myspringproject.dto.user.UserRegistrationCommand;
import com.myspringproject.dto.user.UserResponseDto;
import com.myspringproject.dto.user.UserSearchCommand;
import com.myspringproject.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Collection;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserViewController {

    private final UserService userService;

    @ModelAttribute("searchCommand")
    public UserSearchCommand userSearchCommand() {
        return new UserSearchCommand();
    }


    @GetMapping
    public String findAll(Model model) {

        Collection<UserResponseDto> users = userService.findAllActiveUsers();

        model.addAttribute("users", users);

        return "users";
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

    @DeleteMapping("/{username}")
    public String delete(@PathVariable("username") String username) {

        userService.delete(username);

        return "redirect:/users";
    }

    @GetMapping("/search")
    public String searchUsers(@ModelAttribute @Valid UserSearchCommand command, Model model) {
        Collection<UserResponseDto> searchResults = userService.search(command);
        model.addAttribute("searchResults", searchResults);
        return "search";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("loginCommand", new LoginCommand());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("loginCommand") LoginCommand command, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "login";
        }

        try {
            userService.login(command);
            return "redirect:/users/search"; // Redirect to the search page after successful login
        } catch (ValidationException ex) {
            bindingResult.rejectValue("password", "invalid.credentials", "Invalid username or password");
            return "login";
        }
    }
}
