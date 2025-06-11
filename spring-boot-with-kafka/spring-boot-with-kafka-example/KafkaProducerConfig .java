//Producing Messages:
/**
To produce messages into Apache Kafka, we need to define the configuration class for producer configuration:
*/

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;


@Configuration
public class KafkaProducerConfig{
  @Bean
  ProducerFactory<String, String> producerFactory(){
    Map<String, Object> configProps = new HashMap<>();
    configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

    return new DefaultKafkaProducerFactory<>(configProps);
  }
  
  @Bean
  KafkaTemplate<String, String> kafkaTemplate(){
    return new KafkaTemplate<>(producerFactory());
  }
}

/**
To publish a message, auto wire the Kafka template object and produce the message as shown:
@Autowired
private KafkaTemplate<String, String> kafkaTemplate;

public void sendMessage(String msg){
  kafkaTemplate.send(topicName, msg);
}
*/







