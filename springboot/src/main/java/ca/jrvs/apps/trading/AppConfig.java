package ca.jrvs.apps.trading;

import ca.jrvs.apps.trading.controller.QuoteController;
import ca.jrvs.apps.trading.dao.MarketDataDao;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import ca.jrvs.apps.trading.service.QuoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

@Configuration
public class AppConfig {

    private Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public MarketDataConfig marketDataConfig(){
        return new MarketDataConfig();
    }

    @Bean
    public QuoteService quoteService(QuoteDao quoteDao, MarketDataDao marketDataDao){
        return new QuoteService(quoteDao, marketDataDao);
    }

    @Bean
    public QuoteController quoteController(QuoteService quoteService){
        return new QuoteController(quoteService);
    }

}