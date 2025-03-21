package com.example.jwt;

import com.example.jwt.decoder.SimpleJwtDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtConfig {

  private final JwtProperties properties;

  @Bean
  public JwtDecoder jwtDecoder() {
    if (properties.getValidation().isEnabled()) {
      return NimbusJwtDecoder.withJwkSetUri(properties.getJwkSetUri()).build();
    } else {
      return new SimpleJwtDecoder();
    }
  }
}
