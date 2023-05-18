package io.amigos.springSecurity.dao;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class UserDAO {
    private final static List<UserDetails> APPLICATION_USERS = Arrays.asList(
            new User(
                    "sandeep@gmail.com",
                    "PASSWORD",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_ADMIN"))
            ),
            new User(
                    "sandeepbolla@gmail.com",
                    "PASSWORD",
                    Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"))
            )
    );

    public UserDetails findUserByEmail(String username){
        return  APPLICATION_USERS
                .stream()
                .filter(userDetails -> userDetails.getUsername().equals(username))
                .findFirst()
                .orElseThrow(()->new UsernameNotFoundException("no user was found"));
    }
}
