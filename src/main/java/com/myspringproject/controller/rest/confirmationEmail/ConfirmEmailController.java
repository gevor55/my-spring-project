package com.myspringproject.controller.rest.confirmationEmail;

import com.myspringproject.service.confirmationEmail.ConfirmationEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class ConfirmEmailController {

    private final ConfirmationEmailService confirmationEmailService;


    @RequestMapping(value = "/confirm-account", method = {RequestMethod.GET, RequestMethod.POST})
    public ResponseEntity<?> confirmUserAccount(@RequestParam("token") String confirmationToken) {

        return confirmationEmailService.confirmEmail(confirmationToken);
    }
}
