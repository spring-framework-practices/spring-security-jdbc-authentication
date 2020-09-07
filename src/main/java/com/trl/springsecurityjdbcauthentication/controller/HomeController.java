package com.trl.springsecurityjdbcauthentication.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(
            path = "/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> greetingAll() {
        ResponseEntity<String> response = null;

        String str = "Welcome !!!";

        response = ResponseEntity.ok(str);

        return response;
    }

    @GetMapping(
            path = "/user",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> greetingUser() {
        ResponseEntity<String> response = null;

        String str = "Welcome User !!!";

        response = ResponseEntity.ok(str);

        return response;
    }

    @GetMapping(
            path = "/admin",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> greetingAdmin() {
        ResponseEntity<String> response = null;

        String str = "Welcome Admin !!!";

        response = ResponseEntity.ok(str);

        return response;
    }
}
