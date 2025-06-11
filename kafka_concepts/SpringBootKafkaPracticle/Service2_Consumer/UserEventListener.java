package com.example.fileupload.consumer;

import com.example.fileupload.cache.UsersCache;
import com.example.fileupload.model.Users;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.sterotype.Service;



@Service
public class UserEventListener{
  private final UserCache userCache;
  public UserEventListener(UserCache userCache){
    this.userCache=userCache;
  }

  @KafkaListener(topic="user-topic", groupId="file-upload-consumer-group", containerFactory="kafkaListenerContainerFactory")
  public void listenUsersEvents(Users user){
           System.out.println("📥 Received User from Kafka: " + event.getUserId());
          userCache.addUser(user)
  }
}
