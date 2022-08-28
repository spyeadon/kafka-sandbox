docker exec broker kafka-console-consumer \
  --topic outputTopic \
  --bootstrap-server localhost:9092 \
  --from-beginning \
  --property print.key=true \
  --property key.separator="  "