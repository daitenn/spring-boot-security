package com.example.its.domain.issue.auth;

import com.example.its.domain.issue.auth.User.Authority;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  // repositoryからデータを引っ張ってきて、CustomUserDetailsクラスに変換する処理
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username)
        .map(
              user -> new CustomUserDetails(
                  user.getUsername(),
                  user.getPassword(),
                  toGtantedAuthorityList(user.getAuthority())
              )
        )
        .orElseThrow(
            () -> new UsernameNotFoundException(
                "Given username is not found. (username = '" + username + "')"
            )
        );
  }

  private List<GrantedAuthority> toGtantedAuthorityList(User.Authority authority) {
    return Collections.singletonList(new SimpleGrantedAuthority(authority.name()));
  }
}
