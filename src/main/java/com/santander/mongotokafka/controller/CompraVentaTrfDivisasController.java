package com.santander.mongotokafka.controller;
import com.santander.mongotokafka.service.CompraVentaTrfService;
import com.santander.mongotokafka.dto.CompraVentaTrfDivisasDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CompraVentaTrfDivisasController {


    @Autowired
    CompraVentaTrfService compraVentaTrfService;

    @GetMapping("/getdoc")
    public List<CompraVentaTrfDivisasDto> getAll() {
        return compraVentaTrfService.findAll();
    }
}
