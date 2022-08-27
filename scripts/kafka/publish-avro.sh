SCHEMA="/var/avro-schema/Event.avsc"

docker exec schema-registry kafka-avro-console-producer \
  --broker-list kafkahost:29092 \
  --topic bar \
  --property value.schema.file= "$SCHEMA"