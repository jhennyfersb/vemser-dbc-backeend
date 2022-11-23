package dbc.company.produtoconsumidor.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {
//
//    @Value(value = "${spring.kafka.bootstrap-servers}")
//    private String bootstrapAddress;
//
//    @Bean
//    public KafkaTemplate<String,String> configKafkaTemplate(){
//        Map<String,Object> configProps = new HashMap<>();
//        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);
//        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
//        DefaultKafkaProducerFactory<String,String> kafkaProducerFactory = new DefaultKafkaProducerFactory<>(configProps);
//        return new KafkaTemplate<>(kafkaProducerFactory);
//    }
}
