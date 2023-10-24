package com.myspringproject.service.confirmationEmail;

import com.myspringproject.dto.user.UserStatus;
import com.myspringproject.entities.ConfirmationEmailToken;
import com.myspringproject.entities.User;
import com.myspringproject.repository.ConfirmationEmailRepository;
import com.myspringproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmationEmailServiceImpl implements ConfirmationEmailService {

    private final JavaMailSender javaMailSender;
    private final ConfirmationEmailRepository confirmationEmailRepository;
    private final UserRepository userRepository;

    @Async
    public void sendEmail(SimpleMailMessage email) {
        javaMailSender.send(email);
    }

    @Override
    public ResponseEntity<?> confirmEmail(String confirmationToken) {
        ConfirmationEmailToken token = confirmationEmailRepository.findByConfirmationToken(confirmationToken);

        if (token != null) {
            User user = userRepository.findByEmail(token.getUserEntity().getEmail());
            user.setUserStatus(UserStatus.ACTIVE);
            userRepository.save(user);
            return ResponseEntity.ok("Email verified successfully!");
        }
        return ResponseEntity.badRequest().body("Error: Couldn't verify email");
    }
}
