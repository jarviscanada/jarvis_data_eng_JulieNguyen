package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.dao.MarketDataDao;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import ca.jrvs.apps.trading.model.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class QuoteService {
    private static final Logger logger = LoggerFactory.getLogger(QuoteService.class);

    private QuoteDao quoteDao;
    private MarketDataDao marketDataDao;

    @Autowired
    public QuoteService(QuoteDao quoteDao, MarketDataDao marketDataDao){
        this.quoteDao = quoteDao;
        this.marketDataDao = marketDataDao;
    }

    public void updateMarketData(){
        List<Quote> quoteList = findAllQuotes();
        for(Quote quote : quoteList){
            String ticker = quote.getTicker();
            List<IexQuote> iexQuote = marketDataDao.findAllById(Collections.singleton(ticker));
            Iterable<Quote> buildQuoteFromIEX = iexQuote.stream()
                    .map(QuoteService::buildQuoteFromIexQuote).collect(Collectors.toList());
            quoteDao.save((Quote) buildQuoteFromIEX);
        }
    }

    protected static Quote buildQuoteFromIexQuote(IexQuote iexQuote){
        Quote quote = new Quote();
        quote.setTicker(iexQuote.getSymbol());
        quote.setId(iexQuote.getSymbol());
        quote.setAskPrice((double)iexQuote.getIexAskPrice());
        quote.setBidPrice((double)iexQuote.getIexBidPrice());
        quote.setAskSize(iexQuote.getIexAskSize());
        quote.setBidSize(iexQuote.getIexBidSize());
        return quote;
    }

    public List<Quote> saveQuotes(List<String> tickers){
        List<Quote> list = new ArrayList<>();
        for(String ticker : tickers){
            list.add(quoteDao.save(saveQuote(ticker)));
        }
        return list;
    }

    public Quote saveQuote(String ticker){
        IexQuote iexQuote = findIexQuoteByTicker(ticker);
        Quote quote = buildQuoteFromIexQuote(iexQuote);
        return quote;
    }

    public IexQuote findIexQuoteByTicker(String ticker){
        return marketDataDao.findById(ticker)
                .orElseThrow(() -> new IllegalArgumentException(ticker + "is invalid"));
    }

    public List<Quote> findAllQuotes(){
        return quoteDao.findAll();
    }

}