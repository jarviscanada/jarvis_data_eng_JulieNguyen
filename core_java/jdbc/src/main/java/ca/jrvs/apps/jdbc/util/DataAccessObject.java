package ca.jrvs.apps.jdbc.util;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.sql.*;
import java.util.*;

public abstract class DataAccessObject <T extends DataTransferObject> {

    final Logger logger = LoggerFactory.getLogger(getClass());

    protected final Connection connection;
    protected final static String LAST_VAL = "SELECT last_value FROM ";
    protected final static String CUSTOMER_SEQUENCE = "hp_customer_seq";

    public DataAccessObject(Connection connection){
        super();
        this.connection = connection;
    }

    public abstract T findById(long id);
    public abstract List<T> findAll();
    public abstract T update(T dto);
    public abstract T create(T dto);
    public abstract void delete(long id);

    protected int getLastVal(String sequence){

        int key = 0;
        String sql = LAST_VAL + sequence;
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                key = rs.getInt(1);
            }
            return key;
        }
        catch(SQLException e){
            logger.error("Error: Connection failed", e);
            throw new RuntimeException();
        }
    }

}
