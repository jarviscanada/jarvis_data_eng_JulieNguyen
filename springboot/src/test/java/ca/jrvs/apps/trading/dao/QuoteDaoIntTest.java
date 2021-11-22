package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.TestConfig;
import ca.jrvs.apps.trading.model.config.MarketDataConfig;
import ca.jrvs.apps.trading.model.domain.Quote;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
@Sql({"classpath:schema.sql"})
public class QuoteDaoIntTest {

    @Autowired
    private QuoteDao quoteDao;
    private Quote savedQuote, quote1, quote2, quote3;
    private Quote newQuote;

    @Before
    public void init(){
        savedQuote = new Quote();
    }

    @Before
    public void insertOne(){
        savedQuote.setAskPrice(10d);
        savedQuote.setAskSize(10);
        savedQuote.setBidPrice(10.2d);
        savedQuote.setBidSize(10);
        savedQuote.setId("aapl");
        savedQuote.setLastPrice(10.1d);
        quoteDao.save(savedQuote);
    }

    @Test
    public void findById(){
        assertEquals(savedQuote.toString(), quoteDao.findById("aapl").get().toString());
    }

    @Test
    public void existsById(){
        assertEquals(true, quoteDao.existsById("aapl"));
    }

    @Test
    public void updateOne(){
        newQuote = new Quote();
        newQuote.setAskPrice(20d);
        newQuote.setAskSize(20);
        newQuote.setBidPrice(20.2d);
        newQuote.setBidSize(20);
        newQuote.setId("aapl");
        newQuote.setLastPrice(20.1d);

        quoteDao.save(newQuote);
        assertEquals(newQuote.toString(), quoteDao.findById("aapl").get().toString());
    }

    @Test
    public void findAll(){
        List<Quote>quote = quoteDao.findAll();
        assertEquals(1, quote.size());
    }

    @Test
    public void count(){
        assertEquals(1, quoteDao.count());
    }

    @After
    public void deleteOne(){
        quoteDao.deleteById(savedQuote.getId());
    }

    @After
    public void deleteAll(){
        quoteDao.deleteAll();
    }

}