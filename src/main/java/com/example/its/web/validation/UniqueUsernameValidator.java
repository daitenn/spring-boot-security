package com.example.its.web.validation;

import com.example.its.domain.issue.auth.UserRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

  private final UserRepository userRepository;

  @Override
  public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    return userRepository.findByUsername(value).isEmpty();
  }
}
