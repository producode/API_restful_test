package com.apitest.API_restful_test.controller;

import com.apitest.API_restful_test.entity.*;
import com.apitest.API_restful_test.entity.DTOs.PhoneNumberDTO;
import com.apitest.API_restful_test.entity.DTOs.UserRequestDTO;
import com.apitest.API_restful_test.entity.DTOs.UserResponseDTO;
import com.apitest.API_restful_test.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody @Valid UserRequestDTO userRequestDTO, BindingResult bindingResult) {
        if (!isValidPassword(userRequestDTO.getPassword())){
            return ResponseEntity.badRequest().body("{\"message\":\"contraseña invalida\"}");
        }
        User user = userService.saveUser(userRequestDTO);
        return ResponseEntity.ok(convertToResponseDTO(user));
    }

    private UserResponseDTO convertToResponseDTO(User user) {
        // Convertir el objeto User a UserResponseDTO que contiene solo los campos deseados
        UserResponseDTO responseDTO = new UserResponseDTO(user.getId(), user.getToken().isActive());
        responseDTO.setCreated(user.getToken().getDateCreated());
        responseDTO.setModified(user.getToken().getModified());
        responseDTO.setLastLogin(user.getToken().getLastLogin());
        responseDTO.setToken(user.getToken().getToken());
        responseDTO.setName(user.getName());
        responseDTO.setEmail(user.getEmail());
        responseDTO.setPassword(user.getPassword());
        List<PhoneNumberDTO> phoneNumberDTOS = user.getPhoneNumbers() != null ? user.getPhoneNumbers()
                .stream()
                .map(this::convertToPhoneNumber)
                .collect(Collectors.toList())
                : new ArrayList<>();
        responseDTO.setPhoneNumbers(phoneNumberDTOS);

        return responseDTO;
    }

    private PhoneNumberDTO convertToPhoneNumber(PhoneNumber phoneNumber) {
        return new PhoneNumberDTO(phoneNumber.getNumber(), phoneNumber.getCitycode(), phoneNumber.getCountrycode());
    }

    public static boolean isValidPassword(String password) {
        // Definir la expresión regular para la validación de la contraseña
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$";

        // Compilar la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);

        // Crear un objeto Matcher para verificar si la contraseña coincide con la expresión regular
        Matcher matcher = pattern.matcher(password);

        // Devolver true si la contraseña cumple con los requisitos, false en caso contrario
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        // Definir la expresión regular para la validación de la contraseña
        String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";

        // Compilar la expresión regular en un patrón
        Pattern pattern = Pattern.compile(regex);

        // Crear un objeto Matcher para verificar si la contraseña coincide con la expresión regular
        Matcher matcher = pattern.matcher(email);

        // Devolver true si la contraseña cumple con los requisitos, false en caso contrario
        return matcher.matches();
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}

