package ca.jrvs.apps.jdbc;

import java.sql.*;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

public class JDBCExecutor {

    final Logger logger = LoggerFactory.getLogger(JDBCExecutor.class);

    public static void main(String... args) {
        DatabaseConnectionManager dcm = new DatabaseConnectionManager("localhost", "hplussport", "postgres", "password");
        JDBCExecutor jdbcEx = new JDBCExecutor();
        try{
            Connection connection = dcm.getConnection();
            //Test connection
            /*Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT (*) FROM CUSTOMER");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1));
            }*/
            CustomerDAO customerDAO = new CustomerDAO(connection);

            //Test create customer
            /*Customer customer = new Customer();
            customer.setFirstName("George");
            customer.setLastName("Washington");
            customer.setEmail("george.washington@wh.gov");
            customer.setPhone("(555) 555-6543");
            customer.setAddress("1234 Main St");
            customer.setCity("Mount Vernon");
            customer.setState("VA");
            customer.setZipCode("22121");*/

            //Test find customer
            /*Customer customer = customerDAO.findById(1000);
            System.out.println(customer.getFirstName()+" "+customer.getLastName());*/

            //Test update
            /*Customer customer = customerDAO.findById(10000);
            System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getEmail());
            customer.setEmail("gwashington@wh.gov");
            customer = customerDAO.update(customer);
            System.out.println(customer.getFirstName()+" "+customer.getLastName()+" "+customer.getEmail());
            */

            //Test delete
            /*Customer customer = new Customer();
            customer.setFirstName("John");
            customer.setLastName("Adams");
            customer.setEmail("jadams@wh.gov");
            customer.setPhone("(555) 555-9595");
            customer.setAddress("1234 Main St");
            customer.setCity("Arlington");
            customer.setState("VA");
            customer.setZipCode("01234");

            Customer dbCustomer = customerDAO.create(customer);
            System.out.println(dbCustomer);
            dbCustomer = customerDAO.findById(dbCustomer.getId());
            System.out.println(dbCustomer);
            dbCustomer.setEmail("john.adams@wh.gov");
            dbCustomer = customerDAO.update(dbCustomer);
            System.out.println(dbCustomer);
            customerDAO.delete(dbCustomer.getId());*/

            OrderDAO orderDAO = new OrderDAO(connection);
            Order order = orderDAO.findById(1000);
            System.out.println(order);

        }
        catch(SQLException e){
            jdbcEx.logger.error("Error: Connection failed", e);
        }
    }
}