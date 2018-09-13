package DataAccess;


import java.io.File;
import java.sql.Connection;
import java.sql.*;

import Model.AuthToken;




public class Database {


    public static void loadDatabase(){

        try{
            //load database driver
            final String driver ="org.sqlite.JDBC"; //ask here
            Class.forName(driver);
        }

        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public  void startTransaction() {

        String db_name =  "db" + File.separator + "db.sqlite"; //ask here
        String connectionURL = "jdbc:sqlite:" + db_name;

        Connection connection = null;

        try{
            //Open a database connection
            connection = DriverManager.getConnection(connectionURL);
            //Start transaction
            connection.setAutoCommit(false);

        }
        catch(SQLException e){
            //error
        }
    }


    public void closeTransaction(){

    }

    private UserDao users_dao;
    private PersonDao persons_dao;
    private EventDao events_dao;
    private AuthTokenDao auth_tokens_dao;


    public Database(){

        users_dao = new UserDao();
        persons_dao = new PersonDao();
        events_dao = new EventDao();
        auth_tokens_dao = new AuthTokenDao();

    }

    public UserDao getUserDao(){
        return users_dao;
    }

    public PersonDao getPersonDao(){
        return persons_dao;
    }

    public EventDao getEventDao(){
        return events_dao;
    }
    public AuthTokenDao getAuthTokenDao(){
        return auth_tokens_dao;
    }


/**
 * Call user dao, needs a connection
 * Call database to open a connection
 * send connection to user dao
 * close connection once receive it
 * method or data member
 */

}
