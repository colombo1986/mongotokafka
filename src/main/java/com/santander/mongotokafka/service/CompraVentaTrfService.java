package com.santander.mongotokafka.service;

import com.santander.mongotokafka.dto.CompraVentaTrfDivisasDto;

import java.util.List;

public interface CompraVentaTrfService {

    List<CompraVentaTrfDivisasDto> findAll();

    //CompraVentaTrfDivisasDto findById(String id);
    //CompraVentaTrfDivisasDto save(CompraVentaTrfDivisasDto dto);
    //void deleteById(String id);
}
