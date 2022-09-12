package com.example.usersservice.service.impl;

import com.example.usersservice.domain.dto.AddMoneyDto;
import com.example.usersservice.domain.dto.UserEmailDto;
import com.example.usersservice.domain.dto.UserIdInfoDto;
import com.example.usersservice.domain.dto.UserRegisterDto;
import com.example.usersservice.domain.exceptions.PasswordsDoNotMatchException;
import com.example.usersservice.domain.exceptions.UserAlreadyExistsException;
import com.example.usersservice.domain.models.User;
import com.example.usersservice.domain.models.UserId;
import com.example.usersservice.domain.repository.UserRepository;
import com.example.usersservice.service.interfaces.UserService;
import ddd.sharedkernel.domain.valueobjects.financial.Money;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Boolean passwordMatches(User user, String password) {
        return this.passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @Override
    public void deleteUserByEmail(String email) {
        User user = this.userRepository.findByEmail(email);
        this.userRepository.deleteById(user.getId());
    }

    @Override
    public Optional<User> register(UserRegisterDto userRegisterDto) {
        User user = this.userRepository.findByEmail(userRegisterDto.getEmail());
        if(user != null){
            throw new UserAlreadyExistsException();
        }
        if(!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())){
            throw new PasswordsDoNotMatchException();
        }
        User newUser = new User(
                userRegisterDto.getFirstName(),
                userRegisterDto.getLastName(),
                userRegisterDto.getEmail(),
                passwordEncoder.encode(userRegisterDto.getPassword()));
        this.userRepository.save(newUser);
        return Optional.of(newUser);
    }

    @Override
    public Optional<User> details(UserEmailDto userEmailDto) {
        return Optional.of(this.userRepository.findByEmail(userEmailDto.getEmail()));
    }

    @Override
    public Optional<User> addMoneyToUser(AddMoneyDto addMoneyDto) {
        User user = this.userRepository.findByEmail(addMoneyDto.getEmail());
        user.setMoney(new Money(addMoneyDto.getAmount()));
        return Optional.of(this.userRepository.save(user));
    }

    @Override
    public Optional<User> detailsWithGivenId(UserIdInfoDto userIdInfoDto) {
        UserId userId = new UserId(userIdInfoDto.getId());
        return this.userRepository.findById(userId);
    }
}
