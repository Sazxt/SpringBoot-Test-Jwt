package com.kitabisa.kitabisa.mapper;

import com.kitabisa.kitabisa.dto.TestDataDTO;
import com.kitabisa.kitabisa.model.Testdata;

public class TestMapperDTO {
    public static TestDataDTO toDTO(Testdata testdata) {
        TestDataDTO dto = new TestDataDTO();
        dto.setId(testdata.getId());
        dto.setUsername(testdata.getUsername());
        dto.setAlamat(testdata.getAlamat());
        // dto.setWallet(testdata.getWallet());
        dto.setEmail(testdata.getEmail());
        return dto;
    }

    public static Testdata toEntity(TestDataDTO dto) {
        Testdata testdata = new Testdata();
        testdata.setUsername(dto.getUsername());
        testdata.setAlamat(dto.getAlamat());
        // testdata.setWallet(dto.getWallet());
        testdata.setEmail(dto.getEmail());
        return testdata;
    }
}
