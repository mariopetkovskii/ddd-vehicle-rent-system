package com.example.usersservice.xport.rest;

import com.example.usersservice.domain.dto.UserRegisterDto;
import com.example.usersservice.domain.models.User;
import com.example.usersservice.service.interfaces.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterDto userRegisterDto){
        return this.userService.register(userRegisterDto)
                .map(user -> ResponseEntity.ok().body("User is registered successfully. Please check your email to finish registration."))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/listAll")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<User> listAll(){
        return this.userService.findAll();
    }
}
