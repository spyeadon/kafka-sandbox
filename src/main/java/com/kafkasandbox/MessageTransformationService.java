package com.kafkasandbox;

import org.springframework.stereotype.Service;

@Service
public class MessageTransformationService {
    public Event enrich(Event value) {
        return new Event("ENRICHED: " + value.getData());
    }
}
