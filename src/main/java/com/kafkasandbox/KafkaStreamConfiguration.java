package com.kafkasandbox;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
@Slf4j
public class KafkaStreamConfiguration {

    @Bean
    public Function<KStream<String, String>, KStream<String, String>> eventStream() {
        return stream -> stream
                .peek(((key, value) -> log.info("received event with key: {}", key)))
                .map(((key, value) -> KeyValue.pair(key, "Value: '" + value + "' has been enriched")));
    }
}
