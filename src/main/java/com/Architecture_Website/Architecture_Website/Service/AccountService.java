package com.Architecture_Website.Architecture_Website.Service;

import com.Architecture_Website.Architecture_Website.Model.AccountEntity;
import com.Architecture_Website.Architecture_Website.Repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Encryption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(12);
    private final AuthenticationManager authenticationManager;

    public void createAccount(AccountEntity accountEntity) {
        accountEntity.setPassword(bCryptPasswordEncoder.encode(accountEntity.getPassword()));
        accountRepository.save(accountEntity);
    }

    public ResponseEntity<?> login(String username, String password) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password)
            );

            if (auth.isAuthenticated()) {
                return ResponseEntity.ok("Login success");
            }

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
