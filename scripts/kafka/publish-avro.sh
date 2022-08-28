AVRO_SCHEMA=/var/avro-schema/Event.avsc
KAFKA_SERVER=broker:29092
SCHEMA_REGISTRY_URL=http://localhost:8081
MESSAGE_FILE=/var/kafka/messages/avro-message.json
TOPIC=inputTopic
KEY=$(echo $RANDOM | md5sum | head -c 20)

docker exec -it schema-registry sh -c \
    "cat $MESSAGE_FILE \
            | tr -d '\n' \
            | sed -e 's/^/$KEY\^/;' \
    | kafka-avro-console-producer \
        --bootstrap-server $KAFKA_SERVER \
        --topic $TOPIC \
        --property schema.registry.url=$SCHEMA_REGISTRY_URL \
        --property value.schema.file=$AVRO_SCHEMA \
        --property key.serializer=org.apache.kafka.common.serialization.StringSerializer \
        --property value.serializer=io.confluent.kafka.serializers.KafkaAvroSerializer \
        --property parse.key=true \
        --property print.schema.ids=true \
        --property key.separator=^"

echo "Sent message to topic $TOPIC with key $KEY"