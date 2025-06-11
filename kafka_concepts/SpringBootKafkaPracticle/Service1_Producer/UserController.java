
import com.example.userservice.model.Users;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController{
  private final KafkaTemplate<String, Object> kafkaTemplate;
  private final String topicName="user-topic";

  public UserController(KafkaTemplate<String, Object> kafkaTemplate){
    this.kafkaTemplate=kafkaTemplate;
  }

  @PostMapping String createUser(@RequestBody Users user){
    kafkaTemplate.send(topicName, user.getUserId(), user);
    return "User event sent to kafka";
  }
}
