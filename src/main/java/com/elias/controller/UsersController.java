package com.elias.controller;

import com.elias.Repository.UserRepository;
import com.elias.Service.SenderMailService;
import com.elias.Service.UserService;
import com.elias.UsersDTO.UsersDto;
import com.elias.model.Users;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UsersController {

    private final UserRepository userRepository;


    @Autowired
    private UserService userService;

    @Autowired
    SenderMailService senderMailService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Users> findById(@PathVariable  Long id){
        Users obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public List<Users> list(){
        return userRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Users> create(@RequestBody Users usuarios ){
        // return userRepository.save(usuarios);
        senderMailService.enviar(usuarios.getEmail(),
                "Favor acessar o link a seguir, para validar sua conta http://localhost:4200/users/check/"+(userRepository.findbyLastId()+1),
                "Bem vindo ao nosso site");

        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(usuarios));

    }


    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT )
    public ResponseEntity<Void> remove(@PathVariable Long id){
        findById(id);
        userRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UsersDto> update(@PathVariable Long id, @RequestBody UsersDto objdto){
        Users newObj = userService.update(id, objdto);
        return ResponseEntity.ok().body(new UsersDto(newObj));

    }

    @PutMapping(value = "/reset/{id}")
    public ResponseEntity<UsersDto> resetSenha(@PathVariable Long id){
        Users newObj = userService.resetSenha(id);

        senderMailService.enviar(userService.retornaEmail(id),
                "Sua senha foi alterada por um Administrador. Nova senha: 123456 ",
                "Senha Resetada");

        return ResponseEntity.ok().body(new UsersDto(newObj));

    }

    @RequestMapping(value = "/entrar")
    public ResponseEntity<Users> entrar(@RequestParam String email, @RequestParam String senha){
        return ResponseEntity.ok().body(userService.entrar(email, senha));
    }

    }

