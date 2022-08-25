package com.elias.converter;

import com.elias.UsersDTO.UsersDto;
import com.elias.model.Users;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class ConversorEntidade {

    private ModelMapper mapper;

    public UsersDto toDto(Users entity){
        return mapper.map(entity, UsersDto.class);
    }
}
