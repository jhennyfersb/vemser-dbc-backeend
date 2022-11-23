package dbc.company.produtoconsumidor.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dbc.company.produtoconsumidor.dto.MensagemDTO;
import dbc.company.produtoconsumidor.dto.NomeChat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

@Service
@Slf4j
@RequiredArgsConstructor
public class ConsumidorService {
    private final ObjectMapper objectMapper;

    @KafkaListener(
            topics = "ca3xrcl7-chat1",
            clientIdPrefix = "jhenny",
            topicPartitions = {@TopicPartition(topic = "ca3xrcl7-chat1", partitions = {"0"})}

    )
    public void consumirMensagemGeral(@Payload String mensagem,
                                      @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                      @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                      @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        MensagemDTO mensagemDTOLida = objectMapper.readValue(mensagem, MensagemDTO.class);
        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, mensagem);

        System.out.println(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(mensagemDTOLida.getDataCriacao()) + "[" + mensagemDTOLida.getUsuario() + "] " + ":" + mensagemDTOLida.getMensagem());
    }

    @KafkaListener(
            topics = "ca3xrcl7-chat1",
            clientIdPrefix = "jhenny2",
            topicPartitions = {@TopicPartition(topic = "ca3xrcl7-chat1",partitions = {"7"})}

    )
    public void consumirMensagem(@Payload String mensagem,
                                 @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                                 @Header(KafkaHeaders.RECEIVED_PARTITION_ID) Integer partition,
                                 @Header(KafkaHeaders.OFFSET) Long offset) throws JsonProcessingException {
        log.info("####{consume} offset -> '{}' key -> '{}' -> Consumed Object message -> '{}'  ", offset, key, mensagem);
        MensagemDTO mensagemDTOLida = objectMapper.readValue(mensagem, MensagemDTO.class);


        System.out.println(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(mensagemDTOLida.getDataCriacao())
                + "[" + mensagemDTOLida.getUsuario() + "]" + "(privada)" + ":" + mensagemDTOLida.getMensagem());
    }
}