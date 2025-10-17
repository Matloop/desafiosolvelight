package com.example.desafiosolvelight.infra;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {


    private final Map<String, String> users = new HashMap<>();

    public UserController() {

    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        if(!users.containsKey(user.getName())){
            users.put(user.getName(), user.getPassword());
            System.out.println(users);
            return "Usuário cadastrado com sucesso";
        } else {
            return "Usuário já cadastrado";
        }
    }
    @PostMapping("/api/login")
    public String login(@RequestBody User user) {
        String storedPassword = users.get(user.getName());
        System.out.println(storedPassword);
        System.out.println(users);
        System.out.println(user.getName());
        if(storedPassword != null && storedPassword.equals(user.getPassword())){
            return "Login feito com sucesso";
        } else{
            return "Login falho";
        }
    }


}
