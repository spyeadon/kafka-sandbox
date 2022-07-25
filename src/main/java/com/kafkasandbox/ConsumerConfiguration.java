package com.kafkasandbox;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
@Slf4j
public class ConsumerConfiguration {

    @Bean
    Consumer<KStream<String, String>> subscribe() {
        return input ->
                input.foreach((key, val) -> log.info("Received message with key [{}] and value [{}]", key, val));
    }
}
