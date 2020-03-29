package main;

import config.SampleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan("controller")
@Import(SampleConfig.class)
public class GoogleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GoogleApplication.class);
    }
}
