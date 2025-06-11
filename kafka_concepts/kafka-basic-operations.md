## Single Node-Single Broker Configuration


**Creating a Kafka Topic** − Kafka provides a command line utility named kafka-topics.sh to create topics on the server. Open new terminal and type the below example.
**Syntax**: 
        =>
        bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 
        --partitions 1 --topic topic-name

## List of Topics
To get a list of topics in Kafka server, you can use the following command −
**Syntax**
        => bin/kafka-topics.sh --list --zookeeper localhost:2181


## Start Producer to Send Messages
**Syntax**
      =>
      bin/kafka-console-producer.sh --broker-list localhost:9092 --topic topic-name

## Broker-list − 
      =>
      The list of brokers that we want to send the messages to. In this case we only have one broker. 
      The Config/server.properties file contains broker port id, since we know our broker is listening on port 9092,
      so you can specify it directly.


## Start Consumer to Receive Messages:
**Syntax**:
      =>
      bin/kafka-console-consumer.sh --zookeeper localhost:2181 topic topic-name 
      --from-beginning


## Single Node-Multiple Brokers Configuration:
      =>
      Create Multiple Kafka Brokers − We have one Kafka broker instance already in con-fig/server.properties. Now we need multiple broker instances, 
      so copy the existing server.prop-erties file into two new config files and rename it as server-one.properties and server-two.prop-erties. 
      Then edit both new files and assign the following changes −


**config/server-one.properties**

# The id of the broker. This must be set to a unique integer for each broker.
broker.id=1
# The port the socket server listens on
port=9093
# A comma seperated list of directories under which to store log files
log.dirs=/tmp/kafka-logs-1

**config/server-two.properties**
# The id of the broker. This must be set to a unique integer for each broker.
broker.id=2
# The port the socket server listens on
port=9094
# A comma seperated list of directories under which to store log files
log.dirs=/tmp/kafka-logs-2




# Start Multiple Brokers− After all the changes have been made on three servers then open three new terminals to start each broker one by one.

Broker1
bin/kafka-server-start.sh config/server.properties
Broker2
bin/kafka-server-start.sh config/server-one.properties
Broker3
bin/kafka-server-start.sh config/server-two.properties


# Creating a Topic
**Syntax**
    =>
      bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 3 
      -partitions 1 --topic topic-name

The Describe command is used to check which broker is listening on the current created topic as shown below −
    =>
        bin/kafka-topics.sh --describe --zookeeper localhost:2181 
        --topic Multibrokerappli-cation


# Start Producer to Send Messages
      => This procedure remains the same as in the single broker setup.
        bin/kafka-console-producer.sh --broker-list localhost:9092 
        --topic Multibrokerapplication    
# Start Consumer to Receive Messages
      => This procedure remains the same as shown in the single broker setup.
      bin/kafka-console-consumer.sh --zookeeper localhost:2181 
        topic Multibrokerapplica-tion --from-beginning      



# Basic Topic Operations
      => 
        Modifying a Topic
        As you have already understood how to create a topic in Kafka Cluster. Now let us modify a created topic using the following command
**Syntax**
        bin/kafka-topics.sh zookeeper localhost:2181 --alter --topic topic_name 
        --parti-tions count
        
# Deleting a Topic
To delete a topic, you can use the following syntax.
      =>
      bin/kafka-topics.sh --zookeeper localhost:2181 --delete --topic topic_name


### Note −This will have no impact if delete.topic.enable is not set to true


