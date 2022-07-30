package com.kafkasandbox;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
@Slf4j
public class EventProducer {

    private final StreamBridge streamBridge;

    @Scheduled(fixedDelay = 5000)
    void publish() {

        var key = UUID.randomUUID().toString();

        Message<String> message = MessageBuilder
                .withPayload("some payload")
                .setHeader(KafkaHeaders.MESSAGE_KEY, key)
                .build();

        streamBridge.send("publish-out-0", message);
        log.info("Sent message with [{}]", key);
    }
}
