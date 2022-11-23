package dbc.company.chatkafka.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dbc.company.chatkafka.dto.MensagemDTO;
import dbc.company.chatkafka.dto.NomeChat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutorService {
//    @Value(value = "${kafka.topic}")
//    private String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    public void enviarMensagem(MensagemDTO mensagem, List<NomeChat> chats) throws JsonProcessingException {

        String mensagemStr = objectMapper.writeValueAsString(mensagem);
        chats.forEach(chat -> {
            MessageBuilder<String> stringMessageBuilder = MessageBuilder.withPayload(mensagemStr)
                            .setHeader(KafkaHeaders.TOPIC, chat.getTopico())
                            .setHeader(KafkaHeaders.MESSAGE_KEY, UUID.randomUUID().toString())
                            .setHeader(KafkaHeaders.PARTITION_ID,chat.getParticao());

                    ListenableFuture<SendResult<String, String>> enviadoParaTopico = kafkaTemplate.send(stringMessageBuilder.build());
                    enviadoParaTopico.addCallback(new ListenableFutureCallback<>() {
                        @Override
                        public void onFailure(Throwable ex) {
                            log.error("Erro ao enviar a mensagem! {}", mensagemStr, ex);
                        }

                        @Override
                        public void onSuccess(SendResult<String, String> result) {
                            log.info("Mensagem enviada! {}", mensagemStr);
                        }
                    });
                }

        );
    }
}
