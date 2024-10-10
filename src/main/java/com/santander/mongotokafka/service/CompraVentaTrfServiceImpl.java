package com.santander.mongotokafka.service;

import com.santander.mongotokafka.dto.CompraVentaTrfDivisasDto;
import com.santander.mongotokafka.functions.KafkaProducerService;
import com.santander.mongotokafka.repository.CompraVentaTrfDivisasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class CompraVentaTrfServiceImpl implements CompraVentaTrfService{

    @Autowired
    CompraVentaTrfDivisasRepository compraVentaTrfDivisasRepository;

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Override
    public List<CompraVentaTrfDivisasDto> findAll() {
        return compraVentaTrfDivisasRepository.findAll();
    }


    @Scheduled(fixedRate = 10000)
    public void fetchDocuments() {
        List<CompraVentaTrfDivisasDto> documentos = compraVentaTrfDivisasRepository.findAll();
        log.info("Buscando documentos {}", documentos);

        // Enviar cada documento a Kafka
        documentos.forEach(kafkaProducerService::sendToKafka);
    }



}


//
//    @Override
//    public CompraVentaTrfDivisasDto findById(String id) {return null;}
//
//    @Override
//    public void deleteById(String id) {}
//    @Override
//    public CompraVentaTrfDivisasDto save(CompraVentaTrfDivisasDto dto) {return null;}
//

