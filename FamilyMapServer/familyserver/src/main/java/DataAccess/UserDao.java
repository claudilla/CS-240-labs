package DataAccess;
import Model.User;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.sql.DataSource;



public class UserDao {

    User user;

    /**
     * Checks if the Username already exists in the Database
     * Returns true if it already exists
     * @return
     */
    boolean userNameAlreadyExists(){
     return true;
    }

    /**
     * Checks if the email already exists in the Database
     *  Returns true if it already exists
     * @return
     */
    boolean emailAlreadyExists(){
        return true;
    }
    public UserDao() {
    }

    /**
     * Finds an User from the Database
     * Return an User Object
     * @param user user object
     * @return
     */
    User findUser(User user){
        return null;
    }

    /**
     * Adds an User to a the Database
     * @param user user object
     *
     *                 String username;
    String password;
    String email;
    String firstName;
    String lastName;
    String gender;
    String personID;
     *
     *
     */
    public void addUser(User user) throws Exception {

        PreparedStatement stmt = null;
        Connection con = null;
        try{


            String sql = "ADD INTO User Database ( username, email, firstName, lastName, gender, personID) VALUES (?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getFirstName());
            stmt.setString(3, user.getLastName());
            stmt.setString(4, user.getGender());
            stmt.setString(5, user.getPersonID());


        }

        catch(SQLException e){

            throw new Exception(e);
        }

        finally{

            if(stmt != null){
                stmt.close();}

        }


    }

    /**
     * Updates an User in the Database
     * @param infoUser information user string
     */
    public void updateUser(String infoUser){

    }

    /**
     * Deletes an User from the Database
     * @param username username string
     */
    public void deleteUser(String username){

    }

    /**
     * Clear all the Users from the table
     */
    public void clearUser(){

    }



}
