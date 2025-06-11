import com.example.fileupload.config;
import com.example.fileupload.model.Users;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.*;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.*;

@Configuration
@EnableKafka
public class KafkaConsumerConfig{
  
  @Bean
  public ConsumerFactor<String, Users> consumerFactory(){
    Map<String, Object> config=new HashMap<>();
    config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    config.put(ConsumerConfig.GROUP_ID_CONFIG, "file-upload-consumer-group");
    config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

    return new DefaultKafkaConsumerFactor<>(
      config, 
      new StringDeserializer(),
      new JsonDeserializer<>(Users.class, false)
    );
  }

  @Bean
  public ConcurrentKafkaListenerContainerFactory<String, Users> kafkaListenerContainerFactory(){
    ConcurrentKafkaListenerContainerFactory<String, Users> factory=new ConcurrentKafkaListenerContainerFactory<>();

    factory.setConsumerFactory(consumerFactory());
    return factory;
  }
}
