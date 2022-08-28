##Kafka Sandbox

1. Run `./gradlew clean build` to install dependencies
2. Run `./gradlew clean bootRun` to start Kafka stream application
3. Run `./scripts/kafka/publish-avro.sh` to publish a sample message to `inputTopic`
4. Run `./scripts/kafka/consume-avro.sh` to consume all enriched messages published to `outputTopic`