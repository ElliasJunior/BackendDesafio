package com.elias.Service;

import com.elias.Repository.UserRepository;
import com.elias.UsersDTO.UsersDto;
import com.elias.converter.ConversorEntidade;
import com.elias.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;

    private final ConversorEntidade converter = new ConversorEntidade();

    public Users entrar(String email, String senha) {
       // Users user = userRepository.findByNameAndSenha(usarname, senha);
        return userRepository.findByEmailAndSenha(email, senha);
    }


    public Users findById(Long id){
        Optional<Users> obj = userRepository.findById(id);
        return obj.orElse(null);
    }

    public Users update(Long id, UsersDto objdto) {
        Users obj = findById(id);
        obj.setName(objdto.getName());
        obj.setEmail(objdto.getEmail());
        obj.setSenha(objdto.getSenha());
        obj.setPerfil(objdto.getPerfil());
        obj.setValidado(objdto.getValidado());

        return userRepository.save(obj);
    }

    public Users resetSenha(Long id){
        Users obj = findById(id);
        obj.setSenha(String.valueOf(123456));
        return userRepository.save(obj);
    }
    public String retornaEmail(Long id){
        Users obj = findById(id);
        return obj.getEmail();

    }



}
