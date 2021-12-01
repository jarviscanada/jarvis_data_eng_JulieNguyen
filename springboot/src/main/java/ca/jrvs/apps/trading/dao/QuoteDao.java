package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.model.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataRetrievalFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
public class QuoteDao implements CrudRepository<Quote, String> {

    private static final String TABLE_NAME = "quote";
    private static final String ID_COLUMN_NAME = "ticker";

    private static final Logger logger = LoggerFactory.getLogger(QuoteDao.class);
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public QuoteDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName(TABLE_NAME);
    }

    @Override
    public Quote save(Quote quote) {
        if(existsById(quote.getTicker())){
            int updatedRowNo = updateOne(quote);
            if(updatedRowNo != 1){
                throw new DataRetrievalFailureException("Unable to update quote");
            }
        }
        else{
            addOne(quote);
        }
        return quote;
    }

    private void addOne(Quote quote){
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(quote);
        int row = simpleJdbcInsert.execute(parameterSource);
        if(row!=1){
            throw new IncorrectResultSizeDataAccessException("Failed ot insert", 1, row);
        }
    }

    private int updateOne(Quote quote){
        String update_sql = "UPDATE " + TABLE_NAME + " SET last_price=?, bid_price=?, " +
                "bid_size=?, ask_price=?, ask_size=? WHERE " + ID_COLUMN_NAME + "=?";
        if(!existsById(quote.getTicker()))
            throw new NoSuchElementException("Ticker not found: " + quote.getTicker());
        return jdbcTemplate.update(update_sql, makeUpdateValues(quote));
    }

    private Object[] makeUpdateValues(Quote quote){
        Object[] values = {quote.getLastPrice(), quote.getBidPrice(), quote.getBidSize(),
            quote.getAskPrice(), quote.getAskPrice(), quote.getTicker()};
        return values;
    }

    @Override
    public <S extends Quote> List<S> saveAll(Iterable<S> quotes) {
        List<Quote> quotesList = new ArrayList<Quote>();
        for(S quote : quotes){
            Quote result = save(quote);
            quotesList.add(result);
        }
        return (List<S>) quotesList;
    }

    @Override
    public List<Quote> findAll() {
        String query = "SELECT * FROM " + TABLE_NAME;
        List<Quote> quotes =  jdbcTemplate
                .query(query, BeanPropertyRowMapper.newInstance(Quote.class));
        return quotes;
    }

    @Override
    public Optional<Quote> findById(String ticker) {
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + ID_COLUMN_NAME +
                "='" + ticker + "'";
        Optional<Quote> quote = null;
        try{
             quote = Optional.ofNullable(jdbcTemplate.queryForObject(query,
                    BeanPropertyRowMapper.newInstance(Quote.class)));
        }
        catch(EmptyResultDataAccessException e){
            logger.debug("Can't find trader id:" + e);
        }
        if(quote.isPresent()) {
            return quote;
        }
        return Optional.empty();
    }

    @Override
    public boolean existsById(String ticker) {
        String query = "SELECT " + ID_COLUMN_NAME + " FROM " + TABLE_NAME +
                " WHERE " + ID_COLUMN_NAME + "='" + ticker + "'";
        Optional<Quote> quote;
        try {
            quote = Optional.ofNullable(jdbcTemplate.queryForObject(query,
                    BeanPropertyRowMapper.newInstance(Quote.class)));
        }
        catch(EmptyResultDataAccessException e) {
            return false;
        }
        if(quote.isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public void deleteById(String ticker) {
        if (ticker == null) {
            throw new IllegalArgumentException("Ticker can't be null");
        }
        String query = "DELETE FROM " + TABLE_NAME + " WHERE " + ID_COLUMN_NAME + " =?";
        jdbcTemplate.update(query, ticker);
    }

    @Override
    public long count() {
        String query = "SELECT COUNT(*) FROM " + TABLE_NAME;
        return jdbcTemplate.queryForObject(query, Long.class);
    }

    @Override
    public void deleteAll() {
        String query = "DELETE FROM " + TABLE_NAME;
        jdbcTemplate.update(query);
    }

    @Override
    public void delete(Quote quote) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public void deleteAll(Iterable<? extends Quote> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }

    @Override
    public Iterable<Quote> findAllById(Iterable<String> iterable) {
        throw new UnsupportedOperationException("Not implemented");
    }


}