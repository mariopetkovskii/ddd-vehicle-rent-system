package com.example.usersservice.xport.rest;

import com.example.usersservice.domain.dto.*;
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
@CrossOrigin("http://localhost:3000/")
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

    @PostMapping("/details")
    public ResponseEntity<UserInfoDto> userDetails(@RequestBody UserEmailDto userEmailDto){
        return this.userService.details(userEmailDto)
                .map(user -> {
                    UserInfoDto userInfoDto = new UserInfoDto();
                    userInfoDto.setEmail(user.getEmail());
                    userInfoDto.setFirstName(user.getFirstName());
                    userInfoDto.setLastName(user.getLastName());
                    userInfoDto.setId(user.getId().getId());
                    userInfoDto.setMoney(user.getMoney());
                    userInfoDto.setNumOfRents(user.getNumberOfRents());
                    return ResponseEntity.ok().body(userInfoDto);
                })
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/detailsWithId")
    public ResponseEntity<UserInfoDto> userDetailsWithId(@RequestBody UserIdInfoDto userIdInfoDto){
        return this.userService.detailsWithGivenId(userIdInfoDto)
                .map(user -> {
                    UserInfoDto userInfoDto = new UserInfoDto();
                    userInfoDto.setEmail(user.getEmail());
                    userInfoDto.setFirstName(user.getFirstName());
                    userInfoDto.setLastName(user.getLastName());
                    userInfoDto.setId(user.getId().getId());
                    userInfoDto.setMoney(user.getMoney());
                    userInfoDto.setNumOfRents(user.getNumberOfRents());
                    return ResponseEntity.ok().body(userInfoDto);
                })
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/addMoney")
    public ResponseEntity<UserInfoDto> addMoney(@RequestBody AddMoneyDto addMoneyDto){
        return this.userService.addMoneyToUser(addMoneyDto)
                .map(user -> {
                    UserInfoDto userInfoDto = new UserInfoDto();
                    userInfoDto.setEmail(user.getEmail());
                    userInfoDto.setFirstName(user.getFirstName());
                    userInfoDto.setLastName(user.getLastName());
                    userInfoDto.setId(user.getId().getId());
                    userInfoDto.setMoney(user.getMoney());
                    userInfoDto.setNumOfRents(user.getNumberOfRents());
                    return ResponseEntity.ok().body(userInfoDto);
                })
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/rentCar")
    public ResponseEntity<UserInfoDto> rentCar(@RequestBody RentCarDto rentCarDto){
        return this.userService.rentCar(rentCarDto)
                .map(user -> {
                    UserInfoDto userInfoDto = new UserInfoDto();
                    userInfoDto.setEmail(user.getEmail());
                    userInfoDto.setFirstName(user.getFirstName());
                    userInfoDto.setLastName(user.getLastName());
                    userInfoDto.setId(user.getId().getId());
                    userInfoDto.setMoney(user.getMoney());
                    userInfoDto.setNumOfRents(user.getNumberOfRents());
                    return ResponseEntity.ok().body(userInfoDto);
                })
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
