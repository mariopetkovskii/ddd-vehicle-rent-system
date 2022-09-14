package com.example.usersservice.service.interfaces;

import com.example.usersservice.domain.dto.*;
import com.example.usersservice.domain.models.User;
import com.example.usersservice.domain.models.UserId;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User findByEmail(String email);

    User save(User user);

    Boolean passwordMatches(User user, String password);

    List<User> findAll();

    void deleteUserByEmail(String email);

    Optional<User> register(UserRegisterDto userRegisterDto);

    Optional<User> details(UserEmailDto userEmailDto);

    Optional<User> addMoneyToUser(AddMoneyDto addMoneyDto);

    Optional<User> detailsWithGivenId(UserIdInfoDto userIdInfoDto);

    Optional<User> rentCar(RentCarDto rentCarDto);

    User rentCarIncreaseRents(UserId userId);

}