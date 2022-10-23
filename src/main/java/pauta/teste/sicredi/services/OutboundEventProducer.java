package pauta.teste.sicredi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OutboundEventProducer {

    public static final String QUEUE_NAME = "sicredi.kafka";

    public KafkaTemplate<String, String> kafkaTemplate;

    public void outboundEvent(String event) {
        this.kafkaTemplate.send(QUEUE_NAME, event);
    }
}
