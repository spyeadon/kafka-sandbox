package com.kafkasandbox;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
@RequiredArgsConstructor
public class KafkaStreamConfiguration {

    private final MessageTransformationService transformationService;

    @Bean
    public Function<KStream<String, Event>, KStream<String, Event>> eventStream() {
        return stream -> stream
                .peek((key, value) -> log.info("received event with key: {}", key))
                .map((key, value) -> KeyValue.pair(key, transformationService.enrich(value)));
    }
}
