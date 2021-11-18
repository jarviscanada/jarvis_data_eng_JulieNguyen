package ca.jrvs.apps.trading;

import ca.jrvs.apps.trading.controller.QuoteController;
import ca.jrvs.apps.trading.dao.MarketDataDao;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import ca.jrvs.apps.trading.service.QuoteService;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Configuration
@ComponentScan("ca.jrvs.apps.trading")
public class AppConfig {

    private Logger logger = LoggerFactory.getLogger(AppConfig.class);
    private String jdbcUrl, user, password;


    @Bean
    public MarketDataConfig marketDataConfig(){
        MarketDataConfig marketDataConfig = new MarketDataConfig();
        marketDataConfig.setHost("https://cloud.iexapis.com/v1/");
        marketDataConfig.setToken(System.getenv("IEX_PUB_TOKEN"));
        return new MarketDataConfig();
    }

    @Bean
    public DataSource dataSource() {
        jdbcUrl =
                "jdbc:postgresql://" +
                        System.getenv("PSQL_HOST") + ":" +
                        System.getenv("PSQL_PORT") +
                        "/" +
                        System.getenv("PSQL_DB");
        user = System.getenv("PSQL_USER");
        password = System.getenv("PSQL_PASSWORD");
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(jdbcUrl);
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(password);
        return basicDataSource;
    }

    @Bean
    public HttpClientConnectionManager httpClientConnectionManager() {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(50);
        cm.setDefaultMaxPerRoute(50);
        return cm;
    }

}