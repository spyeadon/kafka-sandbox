MESSAGE_FILE=/var/kafka/messages/string-message.txt

docker exec -it broker sh -c \
    "cat $MESSAGE_FILE \
    | kafka-console-producer \
     --topic inputTopic \
     --broker-list localhost:9092 \
     --property parse.key=true \
     --property key.separator="*""


