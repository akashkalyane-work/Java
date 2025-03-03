package com.example.token_impl.service;

import com.example.token_impl.dto.LoginRequestDto;
import com.example.token_impl.dto.UserRequestDto;
import com.example.token_impl.dto.UserResponseDto;
import com.example.token_impl.entity.User;
import com.example.token_impl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    @Autowired
//    private JwtService jwtService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

//    @Autowired
//    AuthenticationManager authManager;

    public static final Pattern ValidateEmail =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public List<UserResponseDto> getUsers() {
        return userRepository.findAll().stream()
                .map(UserResponseDto::mapToDto)
                .collect(Collectors.toList());
    }

    public UserResponseDto getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User ID not found"));
        return UserResponseDto.mapToDto(user);
    }

    public void addUser(UserRequestDto userRequestDto) {

        List<String> errors = new ArrayList<>();

//        String salt = BCrypt.gensalt();
//        String hashedPassword = BCrypt.hashpw(userRequestDto.getPassword(), salt);

        if (userRequestDto.getUserName() == null || userRequestDto.getUserName().trim().isEmpty())
            errors.add("Username is required");

        if ((userRequestDto.getUserName() != null && !userRequestDto.getUserName().trim().isEmpty()) && userRequestDto.getUserName().trim().length() < 3)
            errors.add("Username must be more than or equals to 3 charters");
        else {
            User userIsExist = userRepository.findByUserName(userRequestDto.getUserName());
            if(userIsExist != null)
                errors.add("Username is already taken");
        }

        if (userRequestDto.getPassword() == null || userRequestDto.getPassword().trim().isEmpty())
            errors.add("Password is required");

        if ((userRequestDto.getPassword() != null && !userRequestDto.getPassword().trim().isEmpty()) && userRequestDto.getPassword().trim().length() < 8)
            errors.add("Password must be more than or equals to 8 charters");

        if (userRequestDto.getEmail() == null || userRequestDto.getEmail().trim().isEmpty())
            errors.add("Email is required");

        if ((userRequestDto.getEmail() != null && !userRequestDto.getEmail().trim().isEmpty()) && !ValidateEmail.matcher(userRequestDto.getEmail()).matches())
            errors.add("Invalid Email");
        else{
            User emailIsExist = userRepository.findByEmail(userRequestDto.getEmail());
            if(emailIsExist != null)
                errors.add("Email already taken");
        }

        if (!errors.isEmpty())
            throw new RuntimeException(String.join("\n", errors));

        User user = new User(null,
                userRequestDto.getEmail(),
                userRequestDto.getUserName(),
//                userRequestDto.getPassword(),
                encoder.encode(userRequestDto.getPassword()),
                null,
                null,
                LocalDateTime.now()
        );
        userRepository.save(user);
    }

    public void updateUser(Integer id, UserRequestDto userRequestDto) {

        List<String> errors = new ArrayList<>();

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User ID not found"));

        if (userRequestDto.getUserName() == null || userRequestDto.getUserName().trim().isEmpty())
            errors.add("Username is required");

        if ((userRequestDto.getUserName() != null && !userRequestDto.getUserName().trim().isEmpty()) && userRequestDto.getUserName().trim().length() < 3)
            errors.add("Username must be more than or equals to 3 charters");
        else {
            User userIsExist = userRepository.findByUserName(userRequestDto.getUserName());
            if(userIsExist != null && !Objects.equals(userIsExist.getUserId(), id))
                errors.add("Username is already taken");
        }

        if (userRequestDto.getPassword() == null || userRequestDto.getPassword().trim().isEmpty())
            errors.add("Password is required");

        if ((userRequestDto.getPassword() != null && !userRequestDto.getPassword().trim().isEmpty()) && userRequestDto.getPassword().trim().length() < 8)
            errors.add("Password must be more than or equals to 8 charters");

        if (userRequestDto.getEmail() == null || userRequestDto.getEmail().trim().isEmpty())
            errors.add("Email is required");

        if ((userRequestDto.getEmail() != null && !userRequestDto.getEmail().trim().isEmpty()) && !ValidateEmail.matcher(userRequestDto.getEmail()).matches())
            errors.add("Invalid Email");
        else{
            User emailIsExist = userRepository.findByEmail(userRequestDto.getEmail());
            if(emailIsExist != null && !Objects.equals(emailIsExist.getUserId(), id))
                errors.add("Email already taken");
        }

        if (!errors.isEmpty())
            throw new RuntimeException(String.join("\n", errors));

        user.setUserName(userRequestDto.getUserName());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(encoder.encode(userRequestDto.getPassword()));

        userRepository.save(user);

    }

    public void deleteUser(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User ID not found"));
        userRepository.delete(user);
    }

    public int validate(LoginRequestDto loginRequestDto) {

        List<String> errors = new ArrayList<>();
        User user = null;

        if (loginRequestDto.getUsername() == null || loginRequestDto.getUsername().trim().isEmpty())
            errors.add("Username is required");
        else{
            if (loginRequestDto.getUsername().trim().length() < 3)
                errors.add("Username must be more than or equals to 3 charters");
            else{
                user = userRepository.findByUserName(loginRequestDto.getUsername());
                if(user == null)
                    errors.add("Username not found");
            }
        }

        if (loginRequestDto.getPassword() == null || loginRequestDto.getPassword().trim().isEmpty())
            errors.add("Password is required");
        else {
            if(loginRequestDto.getPassword().trim().length() < 8)
                errors.add("Password must be more than or equals to 8 charters");
        }

        if(!errors.isEmpty())
            throw new RuntimeException(String.join("\n", errors));

//        if(BCrypt.checkpw(loginRequestDto.getPassword(), user.getHashPassword()))
//            return user.getUserId();

        if(encoder.matches(loginRequestDto.getPassword(), user.getPassword()))
            return user.getUserId();

        return 0;
    }

//    public String verify(LoginRequestDto loginRequestDto){
//        Authentication authentication =
//                authManager.authenticate(new UsernamePasswordAuthenticationToken(
//                        loginRequestDto.getUsername()
//                        , loginRequestDto.getPassword()
//                ));
//        if(authentication.isAuthenticated())
////            return jwtService.generateToken(loginRequestDto.getEmail());
//            return "Success";
//
//        return "Failed";
//    }
}
