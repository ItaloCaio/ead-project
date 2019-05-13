package br.com.eadsimple.service;


import br.com.eadsimple.model.User;
import br.com.eadsimple.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails userDetails;
        User user = Optional.ofNullable(userRepository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<GrantedAuthority> grantedAuthorityAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> grantedAuthorityUser = AuthorityUtils.createAuthorityList("ROLE_USER");

        if (user.getType().equals("ALUNO"))
             userDetails = new org.springframework.security.core.userdetails.User( user.getUsername(), user.getPassword(), grantedAuthorityUser);
        else
        {
            userDetails = new org.springframework.security.core.userdetails.User( user.getUsername(), user.getPassword(), grantedAuthorityAdmin);
        }
        return userDetails;
    }
}
