package com.uic.rentalservice.config;

import com.uic.rentalservice.constant.RentalConstants;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    
    @Bean
    public NewTopic rentalTopic() {
        return new NewTopic(RentalConstants.RENTAL_TOPIC, 1, (short) 1);
    }
}
