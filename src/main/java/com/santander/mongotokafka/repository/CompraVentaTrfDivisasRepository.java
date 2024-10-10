package com.santander.mongotokafka.repository;

import com.santander.mongotokafka.dto.CompraVentaTrfDivisasDto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompraVentaTrfDivisasRepository extends MongoRepository<CompraVentaTrfDivisasDto, String> {


}
