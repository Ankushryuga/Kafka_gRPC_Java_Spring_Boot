## Test Kafka Producer:
    =>
    curl -X POST http://localhost:8080/users \
        -H "Content-Type: application/json"  \
        -d '{"userId":"u123", "name":"Ankush", "email":"ankushraj@example.com"}


## O/P:
    => "User event sent to Kafka"

