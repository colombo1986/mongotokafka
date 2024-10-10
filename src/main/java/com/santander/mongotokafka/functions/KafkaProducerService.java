package com.santander.mongotokafka.functions;
import com.santander.mongotokafka.dto.CompraVentaTrfDivisasDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Service;
import org.springframework.messaging.support.MessageBuilder;


@Service
@Slf4j
public class KafkaProducerService {

    @Autowired
    private StreamBridge streamBridge;

    public void sendToKafka(CompraVentaTrfDivisasDto documento) {
        boolean result = streamBridge.send("output", MessageBuilder.withPayload(documento).build());
        if (result) {
            log.info("Mensaje enviado al tópico correctamente: {}", documento);
        } else {
            log.error("Error al enviar el mensaje al tópico: {}", documento);
        }
    }
}
