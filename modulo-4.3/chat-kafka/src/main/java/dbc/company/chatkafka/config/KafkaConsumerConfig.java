package dbc.company.chatkafka.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class KafkaConsumerConfig {
//    private static final String EARLIEST = "earliest";
//    private static final String LATEST = "latest";
//
//    @Value(value = "${kafka.bootstrap-servers}")
//    private String bootstrapAddress; //localhost:9092
//
//    @Value("${kafka.client-id}")
//    private String clientId; //kafka-consumer-api
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> listenerContainerFactory(){
//        Map<String, Object> props = new HashMap<>();
//        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress); //localhost:9092
//        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        props.put(ConsumerConfig.CLIENT_ID_CONFIG, clientId);
//        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, 10);
//        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, EARLIEST);
//
//        DefaultKafkaConsumerFactory<Object, Object> kafkaConsumerFactory = new DefaultKafkaConsumerFactory<>(props);
//
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(kafkaConsumerFactory);
//
//        return factory;
//    }
}
