package com.myspringproject.service;

import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;

public interface ConfirmationEmailService {
    ResponseEntity<?> confirmEmail(String confirmationToken);

    void sendEmail(SimpleMailMessage email);
}
