package com.Architecture_Website.Architecture_Website.Controller;

import com.Architecture_Website.Architecture_Website.Model.AccountEntity;
import com.Architecture_Website.Architecture_Website.Request.AccountLoginRequest;
import com.Architecture_Website.Architecture_Website.Request.AccountRegisterRequest;
import com.Architecture_Website.Architecture_Website.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    // regis
//    @PostMapping("/register")
//    public ResponseEntity<?> createAccount(
//            @RequestBody AccountRegisterRequest accountRequest
//    ){
//        accountService.createAccount(AccountEntity.builder()
//                .username(accountRequest.username())
//                .password(accountRequest.password())
//                .email(accountRequest.email())
//                .build());
//        return new ResponseEntity<>(accountRequest, HttpStatus.CREATED);
//    }

    // login admin
    @PostMapping("/login")
    public ResponseEntity<?> login(
           @RequestBody AccountLoginRequest accountRequest
    ) {
        return accountService.login(accountRequest.username(), accountRequest.password());
    }
}
