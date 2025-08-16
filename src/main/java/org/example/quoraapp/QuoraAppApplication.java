package org.example.quoraapp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing;

@SpringBootApplication
@EnableReactiveMongoAuditing
public class QuoraAppApplication {

    public static void main(String[] args) {
        // 1) Load .env first
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();

        // 2) Push into system properties so Spring can resolve ${...}
        String port = dotenv.get("PORT");
        if (port != null && !port.isBlank()) {
            System.setProperty("server.port", port);
        }
        String mongo = dotenv.get("MONGODB_URL");
        if (mongo != null && !mongo.isBlank()) {
            System.setProperty("spring.data.mongodb.uri", mongo);
        }

        // 3) Start Spring ONCE
        SpringApplication.run(QuoraAppApplication.class, args);
    }
}
