package com.kafkasandbox;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EventProducer {

    private final StreamBridge streamBridge;

    @Scheduled(fixedDelay = 5000)
    void publish() {

        Message<String> message = MessageBuilder
                .withPayload("some payload")
                .build();

        streamBridge.send("publish-out-0", message);
    }
}