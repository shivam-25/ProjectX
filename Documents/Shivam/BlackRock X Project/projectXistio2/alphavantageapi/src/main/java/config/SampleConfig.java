package config;

import alphavantage.AlphaVantageApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class SampleConfig {

    @Bean
    @Scope("singleton")
    public AlphaVantageApi getAlphaVantageApi(){
        return new AlphaVantageApi();
    }

}
