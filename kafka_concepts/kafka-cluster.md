## Kafka cluster diagram:
![image](https://github.com/user-attachments/assets/c4b03f94-a3fd-4f68-aa70-0c6e58e4f394)



# Broker:
    => Kafka cluster typically consists of multiple brokers to maintain load balance. Kafka brokers are stateless,
       so they use zookeeper for maintaining their cluster state. One kafka broker instance can handle hundreds of thousands
       of reads and writes per second and each bro-ker can handle TB of messages without performance impact. Kafka broker leader 
       election can be done by Zookeeper.

# Zookeeper:
    => Zookeeper is used for managing and coordinating kafka broker. Zookeeper service is mainly used to notify producer and consumer about
       the presence of any new broker in the kafka system or failure of the broker in the kafka system. As per the notification received by 
       the zookeeper regarding presence or failure of the broker then pro-ducer and consumer takes decision and starts coordinating their task 
       with some other broker.

# Producer:
    => Producers push data to brokers. When the new broker is started, all the producers search it and automatically sends a message to that new broker.
       kafka producer doesn't wait for acknowledgements from the broker and sends message as fast as the broker can handle.
       
