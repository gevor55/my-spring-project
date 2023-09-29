package com.myspringproject.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("myapp")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MyApplicationProperties {

    private String greetingMessage;
}
