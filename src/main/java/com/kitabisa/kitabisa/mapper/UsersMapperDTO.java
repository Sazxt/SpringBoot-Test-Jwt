package com.kitabisa.kitabisa.mapper;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.kitabisa.kitabisa.dto.UsersDataDTO;
import com.kitabisa.kitabisa.model.Users;

public class UsersMapperDTO {
    public static UsersDataDTO toDto(Users users)
    {
        UsersDataDTO dto = new UsersDataDTO();
        dto.setId(users.getId());
        dto.setUsername(users.getUsername());
        dto.setEmail(users.getEmail());
        dto.setAlamat(users.getAlamat());
        dto.setTinggkat(users.getTingkat());
        return dto;
    }

    public static UsersDataDTO toEntity(Users users)
    {
        UsersDataDTO dto = new UsersDataDTO();
        dto.setUsername(users.getUsername());
        dto.setEmail(users.getEmail());
        dto.setAlamat(users.getAlamat());
        dto.setTinggkat(users.getTingkat());
        return dto;
    }
}
