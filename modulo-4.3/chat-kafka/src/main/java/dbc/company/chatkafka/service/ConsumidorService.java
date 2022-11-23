package dbc.company.chatkafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dbc.company.chatkafka.dto.MensagemDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {
    private final ObjectMapper objectMapper;

    @KafkaListener(
            clientIdPrefix = "jhenny",
            topicPartitions = {@TopicPartition(topic = "${spring.kafka.topics}", partitions = {"0"})}

    )
    public void consumirMensagemGeral(@Payload String mensagem,
                                      @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                      @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
      MensagemDTO mensagemDTOLida = objectMapper.readValue(mensagem, MensagemDTO.class);

        log.info(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                .format(mensagemDTOLida.getDataCriacao()) + "[" + mensagemDTOLida.getUsuario() + "] " + ":" + mensagemDTOLida.getMensagem());
    }

    @KafkaListener(
            clientIdPrefix = "jhenny2",
            topicPartitions = {@TopicPartition(topic = "${spring.kafka.topics}",partitions = {"7"})}

    )
    public void consumirMensagem(@Payload String mensagem,
                                 @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                 @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                 @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTOLida = objectMapper.readValue(mensagem, MensagemDTO.class);


        log.info(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(mensagemDTOLida.getDataCriacao())
                + "[" + mensagemDTOLida.getUsuario() + "]" + "(privada)" + ":" + mensagemDTOLida.getMensagem());
    }
}